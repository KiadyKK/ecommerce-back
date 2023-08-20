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
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ConditionnementServiceImpl implements ConditionnementService {
    private final ConditionnementMapper conditionnementMapper = Mappers.getMapper(ConditionnementMapper.class);

    @Inject
    ConditionnementRepo conditionnementRepo;

    /**
     * Create Conditionnement
     *
     * @param request ConditionnementRequest
     * @return Status code eg: 201
     */
    @Override
    public Response.Status create(ConditionnementRequest request) {
        //Check if field condArt already exists
        Optional<Conditionnement> optional = Optional.ofNullable(conditionnementRepo.findByCondArt(request.getCondArt()));
        if (optional.isPresent())
            return Response.Status.CONFLICT;

        //Create if not exists
        Conditionnement conditionnement = new Conditionnement(request.getCondArt());
        conditionnementRepo.persist(conditionnement);

        return Response.Status.CREATED;
    }

    /**
     * Get All Conditionnements
     *
     * @return List ConditionnementDto
     */
    @Override
    public List<ConditionnementDto> getAll() {
        List<Conditionnement> conditionnements = conditionnementRepo.listAll();
        return conditionnements.stream().map(conditionnementMapper::entityToDto).toList();
    }
}
