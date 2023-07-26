package com.kiki.models.uniteVente.repo;

import com.kiki.models.uniteVente.entity.UniteVente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface UniteVenteRepo extends PanacheRepository<UniteVente> {
    UniteVente findByUtvArt(String utvArt);
}
