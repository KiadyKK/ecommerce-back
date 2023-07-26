package com.kiki.models.role.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import com.kiki.models.role.entity.Role;

public interface RoleRepo extends PanacheRepository<Role> {
    Role findByRole(String role);
}
