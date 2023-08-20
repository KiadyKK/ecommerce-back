package com.kiki.domain.mappers;

import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.entities.Conditionnement;
import org.mapstruct.Mapper;

@Mapper
public interface ConditionnementMapper {
    ConditionnementDto entityToDto(Conditionnement conditionnement);
}
