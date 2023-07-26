package com.kiki.models.article.repo;

import com.kiki.models.article.entity.Article;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ArticleRepo extends PanacheRepository<Article> {
    Article findByRefArt(String refArt);
}
