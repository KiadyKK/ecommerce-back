package com.kiki.ports.secondary;

import com.kiki.domain.entities.Personne;
import com.kiki.domain.entities.Role;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface PersonneRepo extends PanacheRepository<Personne> {
    Personne findByEmail(String email);

    Personne findByUsername(String username);

    List<Personne> listByUsernameAndRole(String username, String role);

    int updatePending(long id);

    boolean deletePersonne(long id);
}
