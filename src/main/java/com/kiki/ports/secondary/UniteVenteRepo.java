package com.kiki.ports.secondary;

import com.kiki.domain.entities.UniteVente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface UniteVenteRepo extends PanacheRepository<UniteVente> {
    UniteVente findByUtvArt(String utvArt);
}
