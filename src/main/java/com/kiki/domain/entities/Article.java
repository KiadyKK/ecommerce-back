package com.kiki.domain.entities;

import com.kiki.domain.requests.article.ArticleRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    private String refArt;

    @Column
    private String desArt;

    @Column
    private String imgArt;

    @Column
    private String urlArt;

    @Column
    private Double puHT;

    @Column
    private Integer dg;

    @Column
    private Integer md;

    @Column
    private Integer mg;

    @Column
    private LocalDateTime dateArt;

    @ManyToOne
    @JoinColumn(name = "idCatArt")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idCondArt")
    private Conditionnement conditionnement;

    @ManyToOne
    @JoinColumn(name = "idUtvArt")
    private UniteVente uniteVente;

    public Article(ArticleRequest request, Categorie categorie, Conditionnement conditionnement, UniteVente uniteVente) {
        this.refArt = request.getRefArt();
        this.desArt = request.getDesArt();
        this.imgArt = request.getImgArt();
        this.puHT = request.getPuHT();
        this.dg = request.getDg();
        this.md = request.getMd();
        this.mg = request.getDg();
        this.dateArt = LocalDateTime.now();
        this.categorie = categorie;
        this.conditionnement = conditionnement;
        this.uniteVente = uniteVente;
    }
}
