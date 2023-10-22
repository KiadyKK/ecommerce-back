package com.kiki.ports.secondary;

import com.kiki.domain.dto.article.ArticleUpdate;
import com.kiki.domain.entities.Article;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface ArticleRepo extends PanacheRepository<Article> {
    Article findByRefArt(String refArt);

    List<Article> getAll(String catArt, String condArt, String utvArt, String desArt);

    long removeByRef(String refArt);

    int updateByRef(ArticleUpdate articleUpdate);
}
