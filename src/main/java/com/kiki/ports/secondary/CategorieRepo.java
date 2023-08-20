package com.kiki.ports.secondary;

import com.kiki.domain.entities.Categorie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface CategorieRepo extends PanacheRepository<Categorie> {
    Categorie findByCatArt(String catArt);
}
