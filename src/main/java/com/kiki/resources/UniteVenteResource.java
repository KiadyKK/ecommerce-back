package com.kiki.resources;

import com.kiki.adaptors.repo.UniteVenteRepoImpl;
import com.kiki.adaptors.services.UniteVenteAdaptor;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
import com.kiki.domain.services.UniteVenteServiceImpl;
import com.kiki.ports.primary.UniteVenteService;
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
    UniteVenteAdaptor uniteVenteAdaptor;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Administrateur", "Commercial"})
    @Transactional
    @Path("create")
    public Response create(UniteVenteRequest request) {
        return uniteVenteAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return uniteVenteAdaptor.getAll();
    }
}
