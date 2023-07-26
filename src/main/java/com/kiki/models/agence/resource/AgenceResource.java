package com.kiki.models.agence.resource;

import com.kiki.models.agence.request.AgenceRequest;
import com.kiki.models.agence.service.AgenceService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/agence")
@ApplicationScoped
public class AgenceResource {
    @Inject
    AgenceService agenceService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @PermitAll
    @Path("create")
    public Response create(AgenceRequest request) {
        return agenceService.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return agenceService.getAll();
    }
}
