package com.kiki.domain.services;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.entities.UniteVente;
import com.kiki.domain.mappers.UniteVenteMapper;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
import com.kiki.ports.primary.UniteVenteService;
import com.kiki.ports.secondary.UniteVenteRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UniteVenteServiceImpl implements UniteVenteService {
    private final UniteVenteMapper uniteVenteMapper = Mappers.getMapper(UniteVenteMapper.class);

    @Inject
    UniteVenteRepo uniteVenteRepo;

    @Inject
    Logger LOGGER;

    /**
     * Create UniteVente
     *
     * @param request UniteVenteRequest
     * @return Status Code eg:201
     */
    @Override
    public Response create(UniteVenteRequest request) {
        //Check if field utvArt already exists
        Optional<UniteVente> optional = Optional.ofNullable(uniteVenteRepo.findByUtvArt(request.getUtvArt()));
        if (optional.isPresent())
            return Response.status(Response.Status.CONFLICT).entity("Sales unit already exists.").build();

        //Create if not exists
        UniteVente uniteVente = new UniteVente(request.getUtvArt());
        uniteVenteRepo.persist(uniteVente);

        return Response.status(Response.Status.CREATED).entity(uniteVente).build();

    }

    /**
     * Get All UniteVentes
     *
     * @return List UniteVenteDto
     */
    @Override
    public List<UniteVenteDto> getAll(String utvArt) {
        List<UniteVente> uniteVentes = uniteVenteRepo.listByUtvArt(utvArt);
        LOGGER.info("Sales unit size ==> " + uniteVentes.size());
        return uniteVentes.stream().map(uniteVenteMapper::entityToDto).toList();
    }

    @Override
    public int removeById(long id) {
        boolean result = uniteVenteRepo.removeById(id);
        if (result) LOGGER.info("Sales unit with id " + id + " deleted successfully !");
        return (int) id;
    }

    @Override
    public UniteVenteDto update(UniteVenteDto uniteVenteDto) {
        uniteVenteRepo.update(uniteVenteDto);
        LOGGER.info("Sales unit with id " + uniteVenteDto.getId() + " updated successfully !");
        return uniteVenteDto;
    }
}
