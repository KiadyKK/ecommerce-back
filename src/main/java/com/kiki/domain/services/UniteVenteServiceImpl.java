package com.kiki.domain.services;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.entities.UniteVente;
import com.kiki.domain.mappers.UniteVenteMapper;
import com.kiki.ports.primary.UniteVenteService;
import com.kiki.ports.secondary.UniteVenteRepo;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UniteVenteServiceImpl implements UniteVenteService {
    private final UniteVenteMapper uniteVenteMapper = Mappers.getMapper(UniteVenteMapper.class);

    @Inject
    UniteVenteRepo uniteVenteRepo;

    /**
     * Create UniteVente
     *
     * @param request UniteVenteRequest
     * @return Status Code eg:201
     */
    @Override
    public Response.Status create(UniteVenteRequest request) {
        //Check if field utvArt already exists
        Optional<UniteVente> optional = Optional.ofNullable(uniteVenteRepo.findByUtvArt(request.getUtvArt()));
        if (optional.isPresent())
            return Response.Status.CONFLICT;

        //Create if not exists
        UniteVente uniteVente = new UniteVente(request.getUtvArt());
        uniteVenteRepo.persist(uniteVente);

        return Response.Status.CREATED;
    }

    /**
     * Get All UniteVentes
     *
     * @return List UniteVenteDto
     */
    @Override
    public List<UniteVenteDto> getAll() {
        List<UniteVente> uniteVentes = uniteVenteRepo.listAll();
        return uniteVentes.stream().map(uniteVenteMapper::entityToDto).toList();
    }
}
