package com.kiki.adaptors.services;

import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.requests.agence.AgenceRequest;
import com.kiki.ports.primary.AgenceService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class AgenceAdaptor {
    @Inject
    Logger LOGGER;

    private final String AGENCE = "AGENCE";

    @Inject
    AgenceService agenceService;

    public Response create(AgenceRequest request) {
        try {
            return agenceService.create(request);
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll(String agc) {
        List<AgenceDto> agenceDtos = agenceService.getAll(agc);
        return Response.ok(agenceDtos).build();
    }

    public Response removeByAbr(String abrAgc) {
        try {
            String res = agenceService.removeByAbr(abrAgc);
            return Response.ok(res).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response update(AgenceRequest request) {
        try {
            AgenceDto agenceDto = agenceService.update(request);
            return Response.ok(agenceDto).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }
}
