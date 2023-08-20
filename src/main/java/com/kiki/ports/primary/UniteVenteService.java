package com.kiki.ports.primary;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.requests.uniteVente.UniteVenteRequest;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface UniteVenteService {
    Response.Status create(UniteVenteRequest request);

    List<UniteVenteDto> getAll();
}
