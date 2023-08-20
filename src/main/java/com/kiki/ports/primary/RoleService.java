package com.kiki.ports.primary;

import com.kiki.domain.dto.role.RoleDto;
import com.kiki.domain.entities.Role;

import java.util.List;

public interface RoleService {
    void create(String role);

    List<RoleDto> getAll();

    Role getByRole(String Role);
}
