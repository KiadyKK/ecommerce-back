package com.kiki.domain.requests.personne;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;

    private String mdp;
}
