package com.kiki.models.personne.repo;

import com.kiki.models.personne.entity.Personne;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface PersonneRepo extends PanacheRepository<Personne> {
    Personne findByEmail(String email);

    Personne findByUsername(String username);
}
