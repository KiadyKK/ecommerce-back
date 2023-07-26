package com.kiki.models.conditionnement.service;

import com.kiki.models.conditionnement.dto.ConditionnementDto;
import com.kiki.models.conditionnement.entity.Conditionnement;
import com.kiki.models.conditionnement.mapper.ConditionnementMapper;
import com.kiki.models.conditionnement.repo.ConditionnementRepo;
import com.kiki.models.conditionnement.request.ConditionnementRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ConditionnementServiceImpl implements ConditionnementService {
    private final Logger LOGGER = Logger.getLogger(ConditionnementServiceImpl.class);

    private final ConditionnementMapper conditionnementMapper = Mappers.getMapper(ConditionnementMapper.class);

    @Inject
    ConditionnementRepo conditionnementRepo;

    //Create Conditionnement
    @Override
    public Response create(ConditionnementRequest request) {
        try {
            //Check if field condArt already exists
            Optional<Conditionnement> optional = Optional.ofNullable(conditionnementRepo.findByCondArt(request.getCondArt()));
            if (optional.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("Conditioning already exists.").build();

            //Create if not exists
            Conditionnement conditionnement = new Conditionnement(request.getCondArt());
            conditionnementRepo.persist(conditionnement);

            String message = "Conditioning created successfully !";
            LOGGER.info(message);

            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    //Get All Conditionnements
    @Override
    public Response getAll() {
        List<Conditionnement> conditionnements = conditionnementRepo.listAll();
        List<ConditionnementDto> conditionnementDtos = conditionnements.stream().map(conditionnementMapper::entityToDto).toList();
        return Response.ok(conditionnementDtos).build();
    }
}
