package com.kiki.models.personne.dto;

import com.kiki.models.role.dto.RoleDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonneDto1 {
    private Long id;

    private String username;

    private String email;

    private RoleDto role;
}
