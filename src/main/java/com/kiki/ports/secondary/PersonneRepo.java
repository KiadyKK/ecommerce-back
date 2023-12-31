package com.kiki.ports.secondary;

import com.kiki.domain.entities.Personne;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface PersonneRepo extends PanacheRepository<Personne> {
    Personne findByEmail(String email);

    Personne findByUsername(String username);

    List<Personne> listByUsername(String username);
}
