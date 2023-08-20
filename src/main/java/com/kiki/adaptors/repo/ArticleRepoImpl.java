package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Article;
import com.kiki.ports.secondary.ArticleRepo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleRepoImpl implements ArticleRepo {
    @Override
    public Article findByRefArt(String refArt) {
        return find("refArt = ?1", refArt).firstResult();
    }
}
