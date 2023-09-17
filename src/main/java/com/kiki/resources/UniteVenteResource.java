package com.kiki.resources;

import com.kiki.adaptors.services.UniteVenteAdaptor;
import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Administrateur", "Commercial"})
    @Transactional
    public Response create(UniteVenteRequest request) {
        return uniteVenteAdaptor.create(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll(@QueryParam("utvArt") String utvArt) {
        return uniteVenteAdaptor.getAll(utvArt);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    @Path("{id}")
    public Response removeById(@PathParam("id") long id) {
        return uniteVenteAdaptor.deleteById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed({"Administrateur", "Commercial"})
    public Response update(UniteVenteDto uniteVenteDto) {
        return uniteVenteAdaptor.update(uniteVenteDto);
    }
}
