package com.kiki.adaptors.services;

import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.requests.categorie.CategorieRequest;
import com.kiki.ports.primary.CategorieService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class CategorieAdaptor {
    private final Logger LOGGER = Logger.getLogger(CategorieAdaptor.class);

    private final String CATEGORY = "Category";

    @Inject
    CategorieService categorieService;

    public Response create(CategorieRequest request) {
        try {
            return categorieService.create(request);
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response getAll(String catArt) {
        List<CategorieDto> categorieDtos = categorieService.getAll(catArt);
        return Response.ok(categorieDtos).build();
    }

    public Response deleteById(long id) {
        try {
            int result = categorieService.removeById(id);
            return Response.ok(result).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    public Response update(CategorieDto categorieDto) {
        try {
            CategorieDto result = categorieService.update(categorieDto);
            return Response.ok(result).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }
}
