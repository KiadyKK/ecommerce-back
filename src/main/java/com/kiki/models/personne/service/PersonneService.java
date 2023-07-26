package com.kiki.models.personne.service;

import com.kiki.models.personne.request.SignUpRequest;
import jakarta.ws.rs.core.Response;

public interface PersonneService {
    Response signUp(SignUpRequest request);
}
