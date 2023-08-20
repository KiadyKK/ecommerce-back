package com.kiki.domain.mappers;

import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.entities.Categorie;
import org.mapstruct.Mapper;

@Mapper
public interface CategorieMapper {
    CategorieDto entityToDto(Categorie categorie);
}
