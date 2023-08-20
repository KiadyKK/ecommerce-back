package com.kiki.adaptors.repo;

import com.kiki.domain.entities.UniteVente;
import com.kiki.ports.secondary.UniteVenteRepo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UniteVenteRepoImpl implements UniteVenteRepo {
    @Override
    public UniteVente findByUtvArt(String utvArt) {
        return find("utvArt = ?1", utvArt).firstResult();
    }
}
