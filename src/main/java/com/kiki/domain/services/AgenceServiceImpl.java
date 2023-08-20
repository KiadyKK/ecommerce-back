package com.kiki.domain.services;

import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.entities.Agence;
import com.kiki.domain.mappers.AgenceMapper;
import com.kiki.ports.primary.AgenceService;
import com.kiki.ports.secondary.AgenceRepo;
import com.kiki.domain.requests.agence.AgenceRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AgenceServiceImpl implements AgenceService {
    private final AgenceMapper agenceMapper = Mappers.getMapper(AgenceMapper.class);

    @Inject
    AgenceRepo agenceRepo;

    /**
     * @param request from client
     * @return status code eg 201
     */
    @Override
    public Response.Status create(@NotNull AgenceRequest request) {
        //check if field abrAgc already exists
        Optional<Agence> optional = Optional.ofNullable(agenceRepo.findByAbrAgc(request.getAbrAgc()));
        if (optional.isPresent())
            return Response.Status.CONFLICT;

        //Create if not exists
        Agence agence = new Agence(request);
        agenceRepo.persist(agence);

        return Response.Status.CREATED;
    }

    /**
     * Get All Agences
     *
     * @return List AgenceDto
     */
    @Override
    public List<AgenceDto> getAll() {
        List<Agence> agences = agenceRepo.listAll();
        return agences.stream().map(agenceMapper::entityToDto).toList();
    }
}
