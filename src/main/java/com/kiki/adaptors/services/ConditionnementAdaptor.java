package com.kiki.adaptors.services;

import com.kiki.common.Retour;
import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.requests.categorie.CategorieRequest;
import com.kiki.domain.requests.conditionnement.ConditionnementRequest;
import com.kiki.ports.primary.ConditionnementService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class ConditionnementAdaptor {
    private final Logger LOGGER = Logger.getLogger(ConditionnementAdaptor.class);

    private final String CONDITIONNEMENT = "CONDITIONNEMENT";

    @Inject
    ConditionnementService conditionnementService;

    public Response create(ConditionnementRequest request) {
        try {
            Response.Status status = conditionnementService.create(request);
            return new Retour(CONDITIONNEMENT, status).getResponse();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll() {
        List<ConditionnementDto> conditionnementDtos = conditionnementService.getAll();
        return Response.ok(conditionnementDtos).build();
    }
}
