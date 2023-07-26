package com.kiki.models.article.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.categorie.entity.Categorie;
import com.kiki.models.conditionnement.entity.Conditionnement;
import com.kiki.models.uniteVente.entity.UniteVente;

import java.util.Date;

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
    private Integer d_g;

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
}
