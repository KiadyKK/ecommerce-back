package com.kiki.domain.entities;

import com.kiki.domain.entities.id.ApproArticleId;
import com.kiki.domain.entities.id.CommandeapproArticleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commandeappro_article")
public class CommandeapproArticle {
    @EmbeddedId
    private CommandeapproArticleId commandeapproArticleId = new CommandeapproArticleId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idFacComApp")
    @JoinColumn(name = "idFacComApp")
    private CommandeAppro commandeAppro;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idRefArt")
    @JoinColumn(name = "idRefArt")
    private Article article;

    @Column
    private Integer qteArtApp;

    @Column
    private Integer remArtApp;

    @Column
    private Double puArtApp;
}
