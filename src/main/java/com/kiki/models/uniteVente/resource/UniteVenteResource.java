package com.kiki.models.uniteVente.resource;

import com.kiki.models.uniteVente.request.UniteVenteRequest;
import com.kiki.models.uniteVente.service.UniteVenteService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/uniteVente")
@ApplicationScoped
public class UniteVenteResource {
    @Inject
    UniteVenteService uniteVenteService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Administrateur", "Commercial"})
    @Transactional
    @Path("create")
    public Response create(UniteVenteRequest request) {
        return uniteVenteService.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return uniteVenteService.getAll();
    }
}
