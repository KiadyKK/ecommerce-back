package com.kiki.resources;

import com.kiki.adaptors.repo.CategorieRepoImpl;
import com.kiki.adaptors.services.CategorieAdaptor;
import com.kiki.domain.requests.categorie.CategorieRequest;
import com.kiki.domain.services.CategorieServiceImpl;
import com.kiki.ports.primary.CategorieService;
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
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("create")
    public Response create(CategorieRequest request) {
        return categorieAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return categorieAdaptor.getAll();
    }
}
