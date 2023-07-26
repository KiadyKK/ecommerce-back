package com.kiki.models.article.entity;

import com.kiki.models.article.request.ArticleRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.kiki.models.categorie.entity.Categorie;
import com.kiki.models.conditionnement.entity.Conditionnement;
import com.kiki.models.uniteVente.entity.UniteVente;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue
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
        this.mD = request.getMD();
        this.mG = request.getMG();
        this.dateArt = new Date();
        this.categorie = categorie;
        this.conditionnement = conditionnement;
        this.uniteVente = uniteVente;
    }
}
