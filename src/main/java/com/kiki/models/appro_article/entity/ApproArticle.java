package com.kiki.models.appro_article.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.appro.entity.Appro;
import com.kiki.models.appro_article.id.ApproArticleId;
import com.kiki.models.article.entity.Article;

@Getter
@Setter
@Entity
@Table(name = "appro_article")
public class ApproArticle {
    @EmbeddedId
    private ApproArticleId approArticleId = new ApproArticleId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("appro_facApp")
    private Appro appro;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("article_refArt")
    private Article article;

    @Column
    private Integer qteArtApp;

    @Column
    private Integer remArtApp;

    @Column
    private Double puArtApp;
}
