package com.kiki.resources;

import com.kiki.adaptors.repo.AgenceRepoImpl;
import com.kiki.adaptors.services.AgenceAdaptor;
import com.kiki.domain.requests.agence.AgenceRequest;
import com.kiki.domain.services.AgenceServiceImpl;
import com.kiki.ports.primary.AgenceService;
import jakarta.annotation.security.PermitAll;
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
    AgenceAdaptor agenceAdaptor;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @PermitAll
    @Path("create")
    public Response create(AgenceRequest request) {
        return agenceAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll() {
        return agenceAdaptor.getAll();
    }
}
