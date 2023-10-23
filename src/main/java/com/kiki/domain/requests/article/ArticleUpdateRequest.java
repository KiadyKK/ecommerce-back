package com.kiki.domain.requests.article;

import com.kiki.domain.entities.Conditionnement;
import com.kiki.domain.entities.UniteVente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateRequest {
    private String refArt;

    private String desArt;

    private Double puHT;

    private Integer dg;

    private Integer md;

    private Integer mg;

    private Conditionnement conditionnement;

    private UniteVente uniteVente;
}
