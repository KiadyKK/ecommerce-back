package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.domain.entities.id.AgenceArticleId;

@Getter
@Setter
@Entity
@Table(name = "agence_article")
public class AgenceArticle {
    @EmbeddedId
    private AgenceArticleId agenceArticleId = new AgenceArticleId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idAbrAgc")
    @JoinColumn(name = "idAbrAgc")
    private Agence agence;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idRefArt")
    @JoinColumn(name = "idRefArt")
    private Article article;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idDay")
    @JoinColumn(name = "idDay")
    private Day day;

    @Column
    private Integer stkArt;

    @Column
    private String typeMvmt;

    @Column
    private Double puArt;
}
