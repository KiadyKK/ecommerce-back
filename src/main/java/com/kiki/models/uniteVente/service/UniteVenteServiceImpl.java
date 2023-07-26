package com.kiki.models.uniteVente.service;

import com.kiki.models.uniteVente.dto.UniteVenteDto;
import com.kiki.models.uniteVente.entity.UniteVente;
import com.kiki.models.uniteVente.mapper.UniteVenteMapper;
import com.kiki.models.uniteVente.repo.UniteVenteRepo;
import com.kiki.models.uniteVente.request.UniteVenteRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UniteVenteServiceImpl implements UniteVenteService {
    private final Logger LOGGER = Logger.getLogger(UniteVenteServiceImpl.class);

    private final UniteVenteMapper uniteVenteMapper = Mappers.getMapper(UniteVenteMapper.class);

    @Inject
    UniteVenteRepo uniteVenteRepo;

    //Create UniteVente
    @Override
    public Response create(UniteVenteRequest request) {
        try {
            //Check if field utvArt already exists
            Optional<UniteVente> optional = Optional.ofNullable(uniteVenteRepo.findByUtvArt(request.getUtvArt()));
            if (optional.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("sales unit already exists.").build();

            //Create if not exists
            UniteVente uniteVente = new UniteVente(request.getUtvArt());
            uniteVenteRepo.persist(uniteVente);

            String message = "Sales unit created successfully !";
            LOGGER.info(message);

            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().entity(e).build();
        }
    }

    //Get All UniteVentes
    @Override
    public Response getAll() {
        List<UniteVente> uniteVentes = uniteVenteRepo.listAll();
        List<UniteVenteDto> uniteVenteDtos = uniteVentes.stream().map(uniteVenteMapper::entityToDto).toList();
        return Response.ok(uniteVenteDtos).build();
    }
}
