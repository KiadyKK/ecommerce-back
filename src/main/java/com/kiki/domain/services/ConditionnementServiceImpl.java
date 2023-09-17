package com.kiki.domain.services;

import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.entities.Conditionnement;
import com.kiki.domain.mappers.ConditionnementMapper;
import com.kiki.domain.requests.conditionnement.ConditionnementRequest;
import com.kiki.ports.primary.ConditionnementService;
import com.kiki.ports.secondary.ConditionnementRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ConditionnementServiceImpl implements ConditionnementService {
    private final ConditionnementMapper conditionnementMapper = Mappers.getMapper(ConditionnementMapper.class);

    @Inject
    ConditionnementRepo conditionnementRepo;

    @Inject
    Logger LOGGER;

    /**
     * Create Conditionnement
     *
     * @param request ConditionnementRequest
     * @return Status code eg: 201
     */
    @Override
    public Response create(ConditionnementRequest request) {
        //Check if field condArt already exists
        Optional<Conditionnement> optional = Optional.ofNullable(conditionnementRepo.findByCondArt(request.getCondArt()));
        if (optional.isPresent())
            return Response.status(Response.Status.CONFLICT).entity("Conditionnement already exists.").build();

        //Create if not exists
        Conditionnement conditionnement = new Conditionnement(request.getCondArt());
        conditionnementRepo.persist(conditionnement);

        return Response.status(Response.Status.CREATED).entity(conditionnement).build();
    }

    /**
     * Get All Conditionnements
     *
     * @return List ConditionnementDto
     */
    @Override
    public List<ConditionnementDto> getAll(String condArt) {
        List<Conditionnement> conditionnements = conditionnementRepo.listByCondArt(condArt);
        LOGGER.info("Conditionnements size ==> " + conditionnements.size());
        return conditionnements.stream().map(conditionnementMapper::entityToDto).toList();
    }

    @Override
    public int removeById(long id) {
        boolean result = conditionnementRepo.removeById(id);
        if (result) LOGGER.info("Conditionnement with id " + id + " deleted successfully !");
        return (int) id;
    }

    @Override
    public ConditionnementDto update(ConditionnementDto conditionnementDto) {
        conditionnementRepo.update(conditionnementDto);
        LOGGER.info("Conditionnement with id " + conditionnementDto.getId() + " updated successfully !");
        return conditionnementDto;
    }
}
