package com.kiki.resources;

import com.kiki.adaptors.services.ConditionnementAdaptor;
import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.requests.conditionnement.ConditionnementRequest;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Administrateur", "Commercial"})
    @Transactional
    public Response create(ConditionnementRequest request) {
        return conditionnementAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll(@QueryParam("condArt") String condArt) {
        return conditionnementAdaptor.getAll(condArt);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("{id}")
    public Response removeById(@PathParam("id") long id) {
        return conditionnementAdaptor.deleteById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response update(ConditionnementDto conditionnementDto) {
        return conditionnementAdaptor.update(conditionnementDto);
    }
}
