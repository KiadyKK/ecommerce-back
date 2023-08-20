package com.kiki.adaptors.repo;

import com.kiki.ports.secondary.RoleRepo;
import jakarta.enterprise.context.ApplicationScoped;
import com.kiki.domain.entities.Role;

@ApplicationScoped
public class RoleRepoImpl implements RoleRepo {
    @Override
    public Role findByRole(String role) {
        return find("role = ?1", role).firstResult();
    }
}
