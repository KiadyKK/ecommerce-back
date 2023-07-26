package com.kiki.models.agence.mapper;

import com.kiki.models.agence.dto.AgenceDto;
import com.kiki.models.agence.entity.Agence;
import org.mapstruct.Mapper;

@Mapper
public interface AgenceMapper {
    AgenceDto entityToDto(Agence agence);
}
