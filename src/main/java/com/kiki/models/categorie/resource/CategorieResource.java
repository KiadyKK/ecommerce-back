package com.kiki.models.categorie.resource;

import com.kiki.models.categorie.request.CategorieRequest;
import com.kiki.models.categorie.service.CategorieService;
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
    CategorieService categorieService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("create")
    public Response create(CategorieRequest request) {
        return categorieService.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return categorieService.getAll();
    }
}
