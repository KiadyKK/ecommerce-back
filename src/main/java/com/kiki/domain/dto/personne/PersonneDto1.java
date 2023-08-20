package com.kiki.domain.dto.personne;

import com.kiki.domain.dto.role.RoleDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonneDto1 {
    private Long id;

    private String username;

    private String email;

    private Boolean pending;

    private RoleDto role;
}
