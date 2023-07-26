package com.kiki.models.role.service;

import com.kiki.models.role.dto.RoleDto;
import com.kiki.models.role.entity.Role;

import java.util.List;

public interface RoleService {
    void create(String role);

    List<RoleDto> getAll();

    Role getByRole(String Role);
}
