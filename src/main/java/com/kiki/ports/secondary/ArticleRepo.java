package com.kiki.ports.secondary;

import com.kiki.domain.entities.Article;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ArticleRepo extends PanacheRepository<Article> {
    Article findByRefArt(String refArt);
}
