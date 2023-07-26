package com.kiki.models.role.resource;

import com.kiki.models.role.dto.RoleDto;
import com.kiki.models.role.service.RoleService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/role")
@ApplicationScoped
public class RoleResource {
    @Inject
    RoleService roleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<RoleDto> roleDtos = roleService.getAll();
        return Response.ok(roleDtos).build();
    }
}
