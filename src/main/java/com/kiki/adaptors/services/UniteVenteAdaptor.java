package com.kiki.adaptors.services;

import com.kiki.common.Retour;
import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
import com.kiki.ports.primary.UniteVenteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class UniteVenteAdaptor {
    private final Logger LOGGER = Logger.getLogger(UniteVenteAdaptor.class);

    private final String UNITEVENTE = "UNITEVENTE";

    @Inject
    UniteVenteService uniteVenteService;

    public Response create(UniteVenteRequest request) {
        try {
            Response.Status status = uniteVenteService.create(request);
            return new Retour(UNITEVENTE, status).getResponse();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll() {
        List<UniteVenteDto> uniteVenteDtos = uniteVenteService.getAll();
        return Response.ok(uniteVenteDtos).build();
    }
}
