package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Categorie;
import com.kiki.ports.secondary.CategorieRepo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategorieRepoImpl implements CategorieRepo {
    @Override
    public Categorie findByCatArt(String catArt) {
        return find("catArt = ?1", catArt).firstResult();
    }
}
