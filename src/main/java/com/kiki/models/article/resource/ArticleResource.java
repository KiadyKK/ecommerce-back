package com.kiki.models.article.resource;

import com.kiki.models.article.request.ArticleRequest;
import com.kiki.models.article.service.ArticleService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/article")
@ApplicationScoped
public class ArticleResource {
    @Inject
    ArticleService articleService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("create")
    public Response create(@MultipartForm MultipartFormDataInput input) {
        return articleService.create(input);
    }
}
