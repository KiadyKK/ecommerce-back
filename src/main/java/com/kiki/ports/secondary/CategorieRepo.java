package com.kiki.ports.secondary;

import com.kiki.domain.entities.Categorie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface CategorieRepo extends PanacheRepository<Categorie> {
    Categorie findByCatArt(String catArt);

    List<Categorie> listByCatArt(String catArt);

    boolean removeById(long id);
}
