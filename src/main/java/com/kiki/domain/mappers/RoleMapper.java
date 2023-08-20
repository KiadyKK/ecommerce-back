package com.kiki.domain.mappers;

import com.kiki.domain.dto.role.RoleDto;
import com.kiki.domain.entities.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleDto entityToDto(Role role);
}
