package com.kiki.models.role.mapper;

import com.kiki.models.role.dto.RoleDto;
import com.kiki.models.role.entity.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleDto entityToDto(Role role);
}
