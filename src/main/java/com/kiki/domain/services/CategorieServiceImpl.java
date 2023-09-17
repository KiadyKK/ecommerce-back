package com.kiki.domain.services;

import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.entities.Categorie;
import com.kiki.domain.mappers.CategorieMapper;
import com.kiki.domain.requests.categorie.CategorieRequest;
import com.kiki.ports.primary.CategorieService;
import com.kiki.ports.secondary.CategorieRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategorieServiceImpl implements CategorieService {
    private final CategorieMapper categorieMapper = Mappers.getMapper(CategorieMapper.class);

    @Inject
    Logger LOGGER;

    @Inject
    CategorieRepo categorieRepo;

    /**
     * Create categorie
     *
     * @param request CategorieRequest
     */
    @Override
    public Response create(CategorieRequest request) {
        //check if field catArt already exist
        Optional<Categorie> optional = Optional.ofNullable(categorieRepo.findByCatArt(request.getCatArt()));
        if (optional.isPresent())
            return Response.status(Response.Status.CONFLICT).entity("Category already exists.").build();

        //Create if not exists
        Categorie categorie = new Categorie(request.getCatArt());
        categorieRepo.persist(categorie);

        return Response.status(Response.Status.CREATED).entity(categorie).build();
    }

    /**
     * Get All Categories
     *
     * @return List CategorieDto
     */
    @Override
    public List<CategorieDto> getAll(String catArt) {
        List<Categorie> categories = categorieRepo.listByCatArt(catArt);
        LOGGER.info("Categories size ==> " + categories.size());
        return categories.stream().map(categorieMapper::entityToDto).toList();
    }

    @Override
    public int removeById(long id) {
        boolean result = categorieRepo.removeById(id);
        if (result) LOGGER.info("Category with id " + id + " deleted successfully !");
        return (int) id;
    }

    @Override
    public CategorieDto update(CategorieDto categorieDto) {
        categorieRepo.update(categorieDto);
        LOGGER.info("Category with id " + categorieDto.getId() + " updated successfully !");
        return categorieDto;
    }
}
