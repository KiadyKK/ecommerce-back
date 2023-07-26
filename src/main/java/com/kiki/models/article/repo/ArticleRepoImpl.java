package com.kiki.models.article.repo;

import com.kiki.models.article.entity.Article;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleRepoImpl implements ArticleRepo {
    @Override
    public Article findByRefArt(String refArt) {
        return find("refArt = ?1", refArt).firstResult();
    }
}
