package com.kiki.resources;

import com.kiki.adaptors.services.ArticleAdaptor;
import com.kiki.common.InterfaceImplementationUtil;
import com.kiki.domain.services.ArticleServiceImpl;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/article")
@ApplicationScoped
public class ArticleResource {
    @Inject
    ArticleAdaptor articleAdaptor;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("create")
    public Response create(@MultipartForm MultipartFormDataInput input) {
        return articleAdaptor.create(input);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return articleAdaptor.getAll();
    }
}
