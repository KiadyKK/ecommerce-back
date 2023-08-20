package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Personne;
import com.kiki.ports.secondary.PersonneRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonneRepoImpl implements PersonneRepo {
    @Override
    public Personne findByEmail(String email) {
        return find("email = ?1", email).firstResult();
    }

    @Override
    public Personne findByUsername(String username) {
        return find("username = ?1", username).firstResult();
    }

    @Override
    public List<Personne> listByUsername(String username) {
        return list("SELECT p FROM Personne p WHERE p.username LIKE '%"+ username +"%'");
    }
}
