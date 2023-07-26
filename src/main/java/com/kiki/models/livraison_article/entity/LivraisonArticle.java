package com.kiki.models.livraison_article.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.article.entity.Article;
import com.kiki.models.livraison.entity.Livraison;
import com.kiki.models.livraison_article.id.LivraisonArticleId;

@Getter
@Setter
@Entity
@Table(name = "livraison_article")
public class LivraisonArticle {
    @EmbeddedId
    private LivraisonArticleId livraisonArticleId = new LivraisonArticleId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("livraison_facLiv")
    private Livraison livraison;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("article_refArt")
    private Article article;

    @Column
    private Integer qteArtLiv;
}
