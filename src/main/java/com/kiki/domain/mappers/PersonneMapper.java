package com.kiki.domain.mappers;

import com.kiki.domain.dto.personne.PersonneDto1;
import com.kiki.domain.entities.Personne;
import org.mapstruct.Mapper;

@Mapper
public interface PersonneMapper {
    PersonneDto1 entityToDto1(Personne personne);
}
