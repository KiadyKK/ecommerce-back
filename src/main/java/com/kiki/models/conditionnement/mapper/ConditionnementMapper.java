package com.kiki.models.conditionnement.mapper;

import com.kiki.models.conditionnement.dto.ConditionnementDto;
import com.kiki.models.conditionnement.entity.Conditionnement;
import org.mapstruct.Mapper;

@Mapper
public interface ConditionnementMapper {
    ConditionnementDto entityToDto(Conditionnement conditionnement);
}
