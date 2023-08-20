package com.kiki.resources;

import com.kiki.adaptors.repo.ConditionnementRepoImpl;
import com.kiki.adaptors.services.ConditionnementAdaptor;
import com.kiki.domain.requests.conditionnement.ConditionnementRequest;
import com.kiki.domain.services.ConditionnementServiceImpl;
import com.kiki.ports.primary.ConditionnementService;
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
    ConditionnementAdaptor conditionnementAdaptor;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("create")
    public Response create(ConditionnementRequest request) {
        return conditionnementAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return conditionnementAdaptor.getAll();
    }
}
