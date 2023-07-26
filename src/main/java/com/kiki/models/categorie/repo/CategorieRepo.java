package com.kiki.models.categorie.repo;

import com.kiki.models.categorie.entity.Categorie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface CategorieRepo extends PanacheRepository<Categorie> {
    Categorie findByCatArt(String catArt);
}
