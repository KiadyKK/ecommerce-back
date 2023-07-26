package com.kiki.models.personne.repo;

import com.kiki.models.personne.entity.Personne;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonneRepoImpl implements PersonneRepo {
    @Override
    public Personne findByEmail(String email) {
        return find("email = ?1", email).firstResult();
    }
}
