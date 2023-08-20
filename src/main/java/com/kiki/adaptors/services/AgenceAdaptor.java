package com.kiki.adaptors.services;

import com.kiki.common.Retour;
import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.requests.agence.AgenceRequest;
import com.kiki.domain.services.AgenceServiceImpl;
import com.kiki.ports.primary.AgenceService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class AgenceAdaptor {
    private final Logger LOGGER = Logger.getLogger(AgenceAdaptor.class);
    private final String AGENCE = "AGENCE";

    @Inject
    AgenceService agenceService;

    public Response create(AgenceRequest request) {
        try {
            Response.Status status = agenceService.create(request);
            return new Retour(AGENCE, status).getResponse();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll() {
        List<AgenceDto> agenceDtos = agenceService.getAll();
        return Response.ok(agenceDtos).build();
    }
}
