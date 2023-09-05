package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Personne;
import com.kiki.domain.entities.Role;
import com.kiki.ports.secondary.PersonneRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonneRepoImpl implements PersonneRepo {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Personne findByEmail(String email) {
        return find("email = ?1", email).firstResult();
    }

    @Override
    public Personne findByUsername(String username) {
        return find("username = ?1", username).firstResult();
    }

    @Override
    public List<Personne> listByUsernameAndRole(String username, String role) {
        return list("SELECT p FROM Personne p WHERE p.username LIKE '%" + username + "%' " +
                "AND p.role.role LIKE '%" + role + "%'");
    }

    @Override
    public int updatePending(long id) {
       return update("pending = false WHERE id = ?1", id);
    }

    @Override
    public boolean deletePersonne(long id) {
        return deleteById(id);
    }
}
