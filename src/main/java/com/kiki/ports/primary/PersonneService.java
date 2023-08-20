package com.kiki.ports.primary;

import com.kiki.domain.dto.personne.PersonneDto1;
import com.kiki.domain.requests.personne.SignInRequest;
import com.kiki.domain.requests.personne.SignUpRequest;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface PersonneService {
    Response signUp(SignUpRequest request);

    Response signIn(SignInRequest request);

    List<PersonneDto1> getAll(String username, String role);
}
