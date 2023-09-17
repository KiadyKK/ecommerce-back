package com.kiki.resources;

import com.kiki.adaptors.services.CategorieAdaptor;
import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.requests.categorie.CategorieRequest;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categorie")
@ApplicationScoped
public class CategorieResource {
    @Inject
    CategorieAdaptor categorieAdaptor;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response create(CategorieRequest request) {
        return categorieAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll(@QueryParam("catArt") String catArt) {
        return categorieAdaptor.getAll(catArt);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("{id}")
    public Response removeById(@PathParam("id") long id) {
        return categorieAdaptor.deleteById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response update(CategorieDto categorieDto) {
        return categorieAdaptor.update(categorieDto);
    }
}
