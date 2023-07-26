package com.kiki.models.conditionnement.resource;

import com.kiki.models.conditionnement.request.ConditionnementRequest;
import com.kiki.models.conditionnement.service.ConditionnementService;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/conditionnement")
@ApplicationScoped
public class ConditionnementResource {
    @Inject
    ConditionnementService conditionnementService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("create")
    public Response create(ConditionnementRequest request) {
        return conditionnementService.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return conditionnementService.getAll();
    }
}
