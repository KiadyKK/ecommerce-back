package com.kiki.adaptors.services;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
import com.kiki.ports.primary.UniteVenteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class UniteVenteAdaptor {
    private final Logger LOGGER = Logger.getLogger(UniteVenteAdaptor.class);

    private final String UNITEVENTE = "Sales unit";

    @Inject
    UniteVenteService uniteVenteService;

    public Response create(UniteVenteRequest request) {
        try {
            return uniteVenteService.create(request);
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll(String utvArt) {
        List<UniteVenteDto> uniteVenteDtos = uniteVenteService.getAll(utvArt);
        return Response.ok(uniteVenteDtos).build();
    }

    public Response deleteById(long id) {
        try {
            int result = uniteVenteService.removeById(id);
            return Response.ok(result).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response update(UniteVenteDto uniteVenteDto) {
        try {
            UniteVenteDto result = uniteVenteService.update(uniteVenteDto);
            return Response.ok(result).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }
}
