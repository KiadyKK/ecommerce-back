package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.domain.entities.id.ApproArticleId;

@Getter
@Setter
@Entity
@Table(name = "appro_article")
public class ApproArticle {
    @EmbeddedId
    private ApproArticleId approArticleId = new ApproArticleId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idFacApp")
    @JoinColumn(name = "idFacApp")
    private Appro appro;

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
