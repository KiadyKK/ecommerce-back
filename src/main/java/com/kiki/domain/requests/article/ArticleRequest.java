package com.kiki.domain.requests.article;

import com.kiki.domain.entities.Categorie;
import com.kiki.domain.entities.Conditionnement;
import com.kiki.domain.entities.UniteVente;
import lombok.Data;

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

    private Categorie categorie;

    private Conditionnement conditionnement;

    private UniteVente uniteVente;
}
