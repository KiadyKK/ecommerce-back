package com.kiki.adaptors.services;

import com.kiki.common.Retour;
import com.kiki.domain.dto.article.ArticleDto;
import com.kiki.domain.services.ArticleServiceImpl;
import com.kiki.ports.primary.ArticleService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import java.io.File;
import java.util.List;

@ApplicationScoped
public class ArticleAdaptor {
    private final Logger LOGGER = Logger.getLogger(ArticleAdaptor.class);

    private final String ARTICLE = "ARTICLE";

    @Inject
    ArticleService articleService;

    public Response create(MultipartFormDataInput input) {
        Response.Status status = articleService.create(input);
        return new Retour(ARTICLE, status).getResponse();
    }

    public Response getAll(String catArt, String condArt, String utvArt) {
        List<ArticleDto> articleDtos = articleService.getAll(catArt, condArt, utvArt);
        return Response.ok(articleDtos).build();
    }

    public File download(String img) {
        LOGGER.info("Image downloaded successfully !");
        return articleService.download(img);
    }
}
