package com.kiki.models.uniteVente.service;

import com.kiki.models.uniteVente.request.UniteVenteRequest;
import jakarta.ws.rs.core.Response;

public interface UniteVenteService {
    Response create(UniteVenteRequest request);

    Response getAll();
}
