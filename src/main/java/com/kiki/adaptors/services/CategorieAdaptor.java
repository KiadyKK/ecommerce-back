package com.kiki.adaptors.services;

import com.kiki.common.Retour;
import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.requests.categorie.CategorieRequest;
import com.kiki.ports.primary.CategorieService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class CategorieAdaptor {
    private final Logger LOGGER = Logger.getLogger(CategorieAdaptor.class);

    private final String CATEGORIE = "CATEGORIE";

    @Inject
    CategorieService categorieService;

    public Response create(CategorieRequest request) {
        try {
            Response.Status status = categorieService.create(request);
            return new Retour(CATEGORIE, status).getResponse();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll() {
        List<CategorieDto> categorieDtos = categorieService.getAll();
        return Response.ok(categorieDtos).build();
    }
}
