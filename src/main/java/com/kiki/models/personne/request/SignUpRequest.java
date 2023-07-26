package com.kiki.models.personne.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;

    private String mdp;

    private String email;

    private String role;

    private String secretCode;
}
