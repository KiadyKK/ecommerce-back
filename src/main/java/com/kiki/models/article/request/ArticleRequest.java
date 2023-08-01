package com.kiki.models.article.request;

import com.kiki.models.categorie.entity.Categorie;
import com.kiki.models.conditionnement.entity.Conditionnement;
import com.kiki.models.uniteVente.entity.UniteVente;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleRequest {
    private String refArt;

    private String desArt;

    private String imgArt;

    private String urlArt;

    private Double puHT;

    private Integer dg;

    private Integer md;

    private Integer mg;

    private Date dateArt;

    private String categorie;

    private String conditionnement;

    private String uniteVente;
}
