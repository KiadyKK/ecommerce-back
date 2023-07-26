package com.kiki.models.agence.service;

import com.kiki.models.agence.request.AgenceRequest;
import jakarta.ws.rs.core.Response;

public interface AgenceService {
    Response create(AgenceRequest request);

    Response getAll();
}
