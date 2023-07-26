package com.kiki.models.role.dto;

import com.kiki.models.personne.dto.PersonneDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDto1 {
    private Long id;

    private String role;

    private List<PersonneDto> personnes;
}
