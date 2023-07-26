package com.kiki.models.uniteVente.repo;

import com.kiki.models.uniteVente.entity.UniteVente;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UniteVenteRepoImpl implements UniteVenteRepo{
    @Override
    public UniteVente findByUtvArt(String utvArt) {
        return find("utvArt = ?1", utvArt).firstResult();
    }
}
