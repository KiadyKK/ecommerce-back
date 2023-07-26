package com.kiki.models.uniteVente.mapper;

import com.kiki.models.uniteVente.dto.UniteVenteDto;
import com.kiki.models.uniteVente.entity.UniteVente;
import org.mapstruct.Mapper;

@Mapper
public interface UniteVenteMapper {
    UniteVenteDto entityToDto(UniteVente uniteVente);
}
