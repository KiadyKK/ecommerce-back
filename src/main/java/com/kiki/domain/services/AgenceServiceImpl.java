package com.kiki.domain.services;

import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.entities.Agence;
import com.kiki.domain.mappers.AgenceMapper;
import com.kiki.domain.requests.agence.AgenceRequest;
import com.kiki.ports.primary.AgenceService;
import com.kiki.ports.secondary.AgenceRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AgenceServiceImpl implements AgenceService {
    private final AgenceMapper agenceMapper = Mappers.getMapper(AgenceMapper.class);

    @Inject
    Logger LOGGER;

    @Inject
    AgenceRepo agenceRepo;

    /**
     * @param request from client
     * @return status code eg 201
     */
    @Override
    public Response create(@NotNull AgenceRequest request) {
        //check if field abrAgc already exists
        Optional<Agence> optional = Optional.ofNullable(agenceRepo.findByAbrAgc(request.getAbrAgc()));
        if (optional.isPresent())
            return Response.status(Response.Status.CONFLICT).entity("Agency already exists.").build();

        //Create if not exists
        Agence agence = new Agence(request);
        agenceRepo.persist(agence);

        LOGGER.info("Agency " + request.getAgc() + " created successfully !");
        return Response.status(Response.Status.CREATED).entity(agence).build();
    }

    /**
     * Get All Agences
     *
     * @return List AgenceDto
     */
    @Override
    public List<AgenceDto> getAll(String agc) {
        List<Agence> agences = agenceRepo.listByAgc(agc);
        return agences.stream().map(agenceMapper::entityToDto).toList();
    }

    @Override
    public String removeByAbr(String abrAgc) {
        long res = agenceRepo.removeByAbr(abrAgc);
        if (res > 0) LOGGER.info("Agency with abrAgc " + abrAgc + " deleted successfully !");
        return abrAgc;
    }

    @Override
    public AgenceDto update(AgenceRequest request) {
        int res = agenceRepo.updateByAbr(request);
        if (res > 0) LOGGER.info("Agency with abrAgc " + request.getAbrAgc() + " updated successfully !");
        Agence agence = agenceRepo.findByAbrAgc(request.getAbrAgc());
        return agenceMapper.entityToDto(agence);
    }

    @Override
    public AgenceDto getByAbr(String abrAgc) {
        Agence agence = agenceRepo.findByAbrAgc(abrAgc);
        LOGGER.info("Agence " + agence.getAgc() + " is found successfully !");
        return agenceMapper.entityToDto(agence);
    }
}
