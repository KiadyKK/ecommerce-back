package com.kiki.models.personne.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;

    private String mdp;
}
