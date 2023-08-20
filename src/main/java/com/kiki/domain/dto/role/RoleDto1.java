package com.kiki.domain.dto.role;

import com.kiki.domain.dto.personne.PersonneDto;
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
