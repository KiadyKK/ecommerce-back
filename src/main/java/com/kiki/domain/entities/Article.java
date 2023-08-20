package com.kiki.domain.entities;

import com.kiki.domain.requests.article.ArticleRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer mD;

    @Column
    private Integer mG;

    @Column
    private Date dateArt;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    private Conditionnement conditionnement;

    @ManyToOne
    private UniteVente uniteVente;

    public Article(ArticleRequest request, Categorie categorie, Conditionnement conditionnement, UniteVente uniteVente) {
        this.refArt = request.getRefArt();
        this.desArt = request.getDesArt();
        this.imgArt = request.getImgArt();
        this.puHT = request.getPuHT();
        this.dg = request.getDg();
        this.mD = request.getMd();
        this.mG = request.getDg();
        this.dateArt = new Date();
        this.categorie = categorie;
        this.conditionnement = conditionnement;
        this.uniteVente = uniteVente;
    }
}
