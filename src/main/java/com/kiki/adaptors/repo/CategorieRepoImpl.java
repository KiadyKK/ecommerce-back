package com.kiki.adaptors.repo;

import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.entities.Categorie;
import com.kiki.ports.secondary.CategorieRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CategorieRepoImpl implements CategorieRepo {
    @Override
    public Categorie findByCatArt(String catArt) {
        return find("catArt = ?1", catArt).firstResult();
    }

    @Override
    public List<Categorie> listByCatArt(String catArt) {
        return find("catArt LIKE '%" + catArt + "%'").list();
    }

    @Override
    public boolean removeById(long id) {
        return deleteById(id);
    }

    @Override
    public int update(CategorieDto categorieDto) {
        return update("SET catArt = ?1 WHERE id = ?2", categorieDto.getCatArt(), categorieDto.getId());
    }
}
