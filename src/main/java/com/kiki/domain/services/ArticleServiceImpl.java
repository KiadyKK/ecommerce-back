package com.kiki.domain.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiki.common.InterfaceImplementation;
import com.kiki.domain.dto.article.ArticleDto;
import com.kiki.domain.entities.Article;
import com.kiki.domain.entities.Categorie;
import com.kiki.domain.entities.Conditionnement;
import com.kiki.domain.entities.UniteVente;
import com.kiki.domain.mappers.ArticleMapper;
import com.kiki.domain.requests.article.ArticleRequest;
import com.kiki.ports.primary.ArticleService;
import com.kiki.ports.secondary.ArticleRepo;
import com.kiki.ports.secondary.CategorieRepo;
import com.kiki.ports.secondary.ConditionnementRepo;
import com.kiki.ports.secondary.UniteVenteRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

@ApplicationScoped
public class ArticleServiceImpl implements ArticleService {
    @ConfigProperty(name = "upload.directory")
    private String UPLOAD_DIR;
    private final Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class);

    private final ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);

    @Inject
    ArticleRepo articleRepo;

    @Inject
    CategorieRepo categorieRepo;

    @Inject
    ConditionnementRepo conditionnementRepo;

    @Inject
    UniteVenteRepo uniteVenteRepo;

    /**
     * Create Article
     * @param input file and data
     * @return status code eg: 201
     */
    @Override
    public Response.Status create(MultipartFormDataInput input) {
        try {
            //Split file and data
            Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
            InputPart inputPart1 = uploadForm.get("file").get(0);
            InputPart inputPart2 = uploadForm.get("data").get(0);
            InputStream inputStream = inputPart2.getBody(InputStream.class, null);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new InputStreamReader(inputStream, UTF_8));

            ObjectMapper objectMapper = new ObjectMapper();
            ArticleRequest request = objectMapper.readValue(obj.toString(), ArticleRequest.class);
            System.out.println("====> " + request.getImgArt());
            //Check if field refArt already exists
            Optional<Article> optional = Optional.ofNullable(articleRepo.findByRefArt(request.getRefArt()));
            if (optional.isPresent())
                return Response.Status.CONFLICT;

            Categorie categorie = categorieRepo.findByCatArt(request.getCategorie().getCatArt());
            Conditionnement conditionnement = conditionnementRepo.findByCondArt(request.getConditionnement().getCondArt());
            UniteVente uniteVente = uniteVenteRepo.findByUtvArt(request.getUniteVente().getUtvArt());

            //Create if refArt not exists
            Article article = new Article(request, categorie, conditionnement, uniteVente);
            articleRepo.persist(article);

            uploadFile(request.getRefArt(), inputPart1, request.getImgArt());

            return Response.Status.CREATED;
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.Status.INTERNAL_SERVER_ERROR;
        }
    }

    private void uploadFile(String refArt, InputPart inputPart, String fileName) {
        try {
            InputStream inputStream = inputPart.getBody(InputStream.class, null);
            writeFile(refArt, inputStream, fileName);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    private void writeFile(String refArt, InputStream inputStream, String fileName) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStream);
        File customDir = new File(UPLOAD_DIR);
        fileName = customDir.getAbsolutePath() + File.separator + "articles" + File.separator + refArt + "_" + fileName;
        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
    }

    /**
     * Get All Articles
     */
    @Override
    public List<ArticleDto> getAll(String catArt, String condArt, String utvArt) {
        List<Article> articles = articleRepo.getAll(catArt, condArt, utvArt);
        LOGGER.info("Articles size ==> " + articles.size());
        return articles.stream().map(articleMapper::entityToDto).toList();
    }

    @Override
    public File download(String img) {
        return new File(UPLOAD_DIR + File.separator + "articles" + File.separator + img);
    }
}
