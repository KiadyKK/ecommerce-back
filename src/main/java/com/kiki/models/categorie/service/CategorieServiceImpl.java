package com.kiki.models.categorie.service;

import com.kiki.models.categorie.dto.CategorieDto;
import com.kiki.models.categorie.entity.Categorie;
import com.kiki.models.categorie.mapper.CategorieMapper;
import com.kiki.models.categorie.repo.CategorieRepo;
import com.kiki.models.categorie.request.CategorieRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategorieServiceImpl implements CategorieService {
    private final Logger LOGGER = Logger.getLogger(CategorieServiceImpl.class);

    private final CategorieMapper categorieMapper = Mappers.getMapper(CategorieMapper.class);

    @Inject
    CategorieRepo categorieRepo;

    //Create categorie
    @Override
    public Response create(CategorieRequest request) {
        try {
            //check if field catArt already exist
            Optional<Categorie> optional = Optional.ofNullable(categorieRepo.findByCatArt(request.getCatArt()));
            if (optional.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("Category already exists.").build();

            //Create if not exists
            Categorie categorie = new Categorie(request.getCatArt());
            categorieRepo.persist(categorie);

            String message = "Category created successfully !";
            LOGGER.info(message);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    //Get All Categories
    @Override
    public Response getAll() {
        List<Categorie> categories = categorieRepo.listAll();
        List<CategorieDto> categorieDtos = categories.stream().map(categorieMapper::entityToDto).toList();
        return Response.ok(categorieDtos).build();
    }
}
