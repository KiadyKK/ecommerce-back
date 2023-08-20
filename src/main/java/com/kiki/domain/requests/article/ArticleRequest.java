package com.kiki.domain.requests.article;

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

    private String categorie;

    private String conditionnement;

    private String uniteVente;
}
