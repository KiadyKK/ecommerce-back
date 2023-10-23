package com.kiki.resources;

import com.kiki.adaptors.services.AgenceAdaptor;
import com.kiki.domain.requests.agence.AgenceRequest;
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
    AgenceAdaptor agenceAdaptor;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response create(AgenceRequest request) {
        return agenceAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll(@QueryParam("agc") String agc) {
        return agenceAdaptor.getAll(agc);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("{abrAgc}")
    public Response removeByAbr(@PathParam("abrAgc") String abrAgc) {
        return agenceAdaptor.removeByAbr(abrAgc);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response update(AgenceRequest request) {
        return agenceAdaptor.update(request);
    }
}
