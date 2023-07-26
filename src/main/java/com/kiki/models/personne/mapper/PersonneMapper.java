package com.kiki.models.personne.mapper;

import com.kiki.models.personne.dto.PersonneDto;
import com.kiki.models.personne.dto.PersonneDto1;
import com.kiki.models.personne.entity.Personne;
import org.mapstruct.Mapper;

@Mapper
public interface PersonneMapper {
    PersonneDto1 entityToDto1(Personne personne);
}
