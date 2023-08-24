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
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategorieServiceImpl implements CategorieService {
    private final CategorieMapper categorieMapper = Mappers.getMapper(CategorieMapper.class);

    @Inject
    CategorieRepo categorieRepo;

    /**
     * Create categorie
     *
     * @param request CategorieRequest
     * @return status code eg: 201
     */
    @Override
    public Response.Status create(CategorieRequest request) {
        //check if field catArt already exist
        Optional<Categorie> optional = Optional.ofNullable(categorieRepo.findByCatArt(request.getCatArt()));
        if (optional.isPresent())
            return Response.Status.CONFLICT;

        //Create if not exists
        Categorie categorie = new Categorie(request.getCatArt());
        categorieRepo.persist(categorie);

        return Response.Status.CREATED;
    }

    /**
     * Get All Categories
     *
     * @return List CategorieDto
     */
    @Override
    public List<CategorieDto> getAll() {
        List<Categorie> categories = categorieRepo.listAll();
        return categories.stream().map(categorieMapper::entityToDto).toList();
    }
}
