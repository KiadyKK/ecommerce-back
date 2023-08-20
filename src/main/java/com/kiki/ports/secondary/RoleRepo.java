package com.kiki.ports.secondary;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import com.kiki.domain.entities.Role;

public interface RoleRepo extends PanacheRepository<Role> {
    Role findByRole(String role);
}
