package com.kiki.models.categorie.mapper;

import com.kiki.models.categorie.dto.CategorieDto;
import com.kiki.models.categorie.entity.Categorie;
import org.mapstruct.Mapper;

@Mapper
public interface CategorieMapper {
    CategorieDto entityToDto(Categorie categorie);
}
