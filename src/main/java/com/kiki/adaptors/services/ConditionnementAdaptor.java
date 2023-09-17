package com.kiki.adaptors.services;

import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.requests.conditionnement.ConditionnementRequest;
import com.kiki.ports.primary.ConditionnementService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class ConditionnementAdaptor {
    private final Logger LOGGER = Logger.getLogger(ConditionnementAdaptor.class);

    private final String CONDITIONNEMENT = "Conditionnement";

    @Inject
    ConditionnementService conditionnementService;

    public Response create(ConditionnementRequest request) {
        try {
            return conditionnementService.create(request);
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll(String condArt) {
        List<ConditionnementDto> conditionnementDtos = conditionnementService.getAll(condArt);
        return Response.ok(conditionnementDtos).build();
    }

    public Response deleteById(long id) {
        try {
            int result = conditionnementService.removeById(id);
            return Response.ok(result).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response update(ConditionnementDto conditionnementDto) {
        try {
            ConditionnementDto result = conditionnementService.update(conditionnementDto);
            return Response.ok(result).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }
}
