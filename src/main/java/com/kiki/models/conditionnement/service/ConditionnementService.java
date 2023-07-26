package com.kiki.models.conditionnement.service;

import com.kiki.models.conditionnement.request.ConditionnementRequest;
import jakarta.ws.rs.core.Response;

public interface ConditionnementService {
    Response create(ConditionnementRequest request);

    Response getAll();
}
