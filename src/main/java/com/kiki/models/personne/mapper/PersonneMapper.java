package com.kiki.models.personne.mapper;

import com.kiki.models.personne.dto.PersonneDto;
import com.kiki.models.personne.entity.Personne;
import org.mapstruct.Mapper;

@Mapper
public interface PersonneMapper {
    PersonneDto entityToDto(Personne personne);
}
