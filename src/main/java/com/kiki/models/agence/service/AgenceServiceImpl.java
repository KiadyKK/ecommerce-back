package com.kiki.models.agence.service;

import com.kiki.models.agence.dto.AgenceDto;
import com.kiki.models.agence.entity.Agence;
import com.kiki.models.agence.mapper.AgenceMapper;
import com.kiki.models.agence.repo.AgenceRepo;
import com.kiki.models.agence.request.AgenceRequest;
import com.kiki.models.categorie.entity.Categorie;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AgenceServiceImpl implements AgenceService {
    private final Logger LOGGER = Logger.getLogger(AgenceServiceImpl.class);

    private final AgenceMapper agenceMapper = Mappers.getMapper(AgenceMapper.class);

    @Inject
    AgenceRepo agenceRepo;

    //Create Agence
    @Override
    public Response create(AgenceRequest request) {
        try {
            //check if field abrAgc already exists
            Optional<Agence> optional = Optional.ofNullable(agenceRepo.findByAbrAgc(request.getAbrAgc()));
            if (optional.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("Agence already exists.").build();

            //Create if not exists
            Agence agence = new Agence(request);
            agenceRepo.persist(agence);

            String message = "Agence created successfully !";
            LOGGER.info(message);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    //Get All Agences
    @Override
    public Response getAll() {
        List<Agence> agences = agenceRepo.listAll();
        List<AgenceDto> agenceDtos = agences.stream().map(agenceMapper::entityToDto).toList();
        return Response.ok(agenceDtos).build();
    }
}
