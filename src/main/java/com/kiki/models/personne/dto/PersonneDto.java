package com.kiki.models.personne.dto;

import lombok.Getter;
import lombok.Setter;
import com.kiki.models.role.dto.RoleDto;

@Getter
@Setter
public class PersonneDto {
    private Long id;

    private String username;

    private String email;

    private String mdp;

    private Boolean pending;

//    private RoleDto role;
}
