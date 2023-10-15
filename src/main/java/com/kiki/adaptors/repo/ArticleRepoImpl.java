package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Article;
import com.kiki.ports.secondary.ArticleRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ArticleRepoImpl implements ArticleRepo {
    @Override
    public Article findByRefArt(String refArt) {
        return find("refArt = ?1", refArt).firstResult();
    }

    @Override
    public List<Article> getAll(String catArt, String condArt, String utvArt) {
        return find("categorie.catArt LIKE '%" + catArt + "%' AND conditionnement.condArt LIKE '%" + condArt + "%'" +
                " AND uniteVente.utvArt LIKE '%" + utvArt + "%'").list();
    }
}
