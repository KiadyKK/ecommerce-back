package com.kiki.domain.mappers;

import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.entities.Agence;
import org.mapstruct.Mapper;

@Mapper
public interface AgenceMapper {
    AgenceDto entityToDto(Agence agence);
}
