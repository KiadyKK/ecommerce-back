package com.kiki.models.article.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiki.models.article.dto.ArticleDto;
import com.kiki.models.article.entity.Article;
import com.kiki.models.article.mapper.ArticleMapper;
import com.kiki.models.article.repo.ArticleRepo;
import com.kiki.models.article.request.ArticleRequest;
import com.kiki.models.categorie.entity.Categorie;
import com.kiki.models.categorie.repo.CategorieRepo;
import com.kiki.models.conditionnement.entity.Conditionnement;
import com.kiki.models.conditionnement.repo.ConditionnementRepo;
import com.kiki.models.uniteVente.entity.UniteVente;
import com.kiki.models.uniteVente.repo.UniteVenteRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jaxb.core.v2.model.core.Ref;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jetbrains.annotations.NotNull;
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

    //Create Article
    @Override
    public Response create(MultipartFormDataInput input) {
        try {
            //Split file and data
            Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
            InputPart inputPart = uploadForm.get("file").get(0);
            InputPart inputPart2 = uploadForm.get("data").get(0);
            InputStream inputStream = inputPart2.getBody(InputStream.class, null);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new InputStreamReader(inputStream, UTF_8));

            ObjectMapper objectMapper = new ObjectMapper();
            ArticleRequest request = objectMapper.readValue(obj.toString(), ArticleRequest.class);

            //Check if field refArt already exists
            Optional<Article> optional = Optional.ofNullable(articleRepo.findByRefArt(request.getRefArt()));
            if (optional.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("Reference already exists.").build();

            Categorie categorie = categorieRepo.findByCatArt(request.getCategorie());
            Conditionnement conditionnement = conditionnementRepo.findByCondArt(request.getConditionnement());
            UniteVente uniteVente = uniteVenteRepo.findByUtvArt(request.getUniteVente());

            //Create if refArt not exists
            Article article = new Article(request, categorie, conditionnement, uniteVente);
            articleRepo.persist(article);

            uploadFile(request.getRefArt(), inputPart, request.getImgArt());

            String message = "Article created successfully !";
            LOGGER.info(message);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
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
        fileName = customDir.getAbsolutePath() + File.separator + refArt + fileName;
        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE_NEW);
    }

    //Get All Articles
    @Override
    public Response getAll() {
        List<Article> articles = articleRepo.listAll();
        List<ArticleDto> articleDtos = articles.stream().map(articleMapper::entityToDto).toList();
        return Response.ok(articleDtos).build();
    }
}
