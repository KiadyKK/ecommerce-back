package com.kiki.models.categorie.repo;

import com.kiki.models.categorie.entity.Categorie;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategorieRepoImpl implements CategorieRepo {
    @Override
    public Categorie findByCatArt(String catArt) {
        return find("catArt = ?1", catArt).firstResult();
    }
}
