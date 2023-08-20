package com.kiki.adaptors.services;

import com.kiki.domain.dto.role.RoleDto;
import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.ports.primary.RoleService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class RoleAdaptor {
    @Inject
    Logger LOGGER;

    @Inject
    RoleService roleService;

    public Response getAll() {
        List<RoleDto> roleDtos = roleService.getAll();
        return Response.ok(roleDtos).build();
    }
}
