package com.kiki.domain.services;

import com.kiki.domain.dto.role.RoleDto;
import com.kiki.domain.mappers.RoleMapper;
import com.kiki.ports.primary.RoleService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.kiki.domain.entities.Role;
import com.kiki.ports.secondary.RoleRepo;
import lombok.AllArgsConstructor;
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
