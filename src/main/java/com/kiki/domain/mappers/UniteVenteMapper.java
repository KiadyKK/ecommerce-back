package com.kiki.domain.mappers;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.entities.UniteVente;
import org.mapstruct.Mapper;

@Mapper
public interface UniteVenteMapper {
    UniteVenteDto entityToDto(UniteVente uniteVente);
}
