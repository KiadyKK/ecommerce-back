package com.kiki.ports.secondary;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.entities.UniteVente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface UniteVenteRepo extends PanacheRepository<UniteVente> {
    UniteVente findByUtvArt(String utvArt);

    List<UniteVente> listByUtvArt(String utvArt);

    boolean removeById(long id);

    int update(UniteVenteDto uniteVenteDto);
}
