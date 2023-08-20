package com.kiki.domain.dto.personne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonneDto {
    private Long id;

    private String username;

    private String email;

    private Boolean pending;
}
