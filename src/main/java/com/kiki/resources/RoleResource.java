package com.kiki.resources;

import com.kiki.adaptors.services.RoleAdaptor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/role")
@ApplicationScoped
public class RoleResource {
    @Inject
    RoleAdaptor roleAdaptor;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return roleAdaptor.getAll();
    }
}
