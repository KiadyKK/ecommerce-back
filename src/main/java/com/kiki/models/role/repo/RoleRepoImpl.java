package com.kiki.models.role.repo;

import jakarta.enterprise.context.ApplicationScoped;
import com.kiki.models.role.entity.Role;

@ApplicationScoped
public class RoleRepoImpl implements RoleRepo {
    @Override
    public Role findByRole(String role) {
        return find("role = ?1", role).firstResult();
    }
}
