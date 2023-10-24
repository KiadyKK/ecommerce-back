package com.kiki.domain.entities;

import com.kiki.domain.entities.id.CommandelivraisonArticleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commandelivraison_article")
public class CommandelivraisonArticle {
    @EmbeddedId
    private CommandelivraisonArticleId commandelivraisonArticleId = new CommandelivraisonArticleId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idFacComLiv")
    @JoinColumn(name = "idFacComLiv")
    private CommandeLivraison commandeLivraison;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idRefArt")
    @JoinColumn(name = "idRefArt")
    private Article article;

    @Column
    private Integer qteArtLiv;

    @Column
    private double puArtLiv;
}
