package com.kiki.models.role.service;

import com.kiki.models.role.dto.RoleDto;
import com.kiki.models.role.mapper.RoleMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.kiki.models.role.entity.Role;
import com.kiki.models.role.repo.RoleRepo;
import org.mapstruct.factory.Mappers;

import java.util.List;

@ApplicationScoped
public class RoleServiceIpml implements RoleService {
    @Inject
    RoleRepo roleRepo;

    private final RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);

    @Override
    public void create(String role) {
        Role newRole = new Role(role);
        roleRepo.persist(newRole);
    }

    @Override
    public List<RoleDto> getAll() {
        List<Role> roles = roleRepo.listAll();
        return roles.stream().map(roleMapper::entityToDto).toList();
    }

    @Override
    public Role getByRole(String role) {
        return roleRepo.findByRole(role);
    }
}
