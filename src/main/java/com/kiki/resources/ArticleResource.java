package com.kiki.resources;

import com.kiki.adaptors.services.ArticleAdaptor;
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

import java.io.File;

@Path("/article")
@ApplicationScoped
public class ArticleResource {
    @Inject
    ArticleAdaptor articleAdaptor;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response create(@MultipartForm MultipartFormDataInput input) {
        return articleAdaptor.create(input);
    }

    @GET
    @Path("/download/{img}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam("img") String img) {
        File file = articleAdaptor.download(img);
        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll(@QueryParam("catArt") String catArt, @QueryParam("condArt") String condArt, @QueryParam("utvArt") String utvArt) {
        return articleAdaptor.getAll(catArt, condArt, utvArt);
    }
}
