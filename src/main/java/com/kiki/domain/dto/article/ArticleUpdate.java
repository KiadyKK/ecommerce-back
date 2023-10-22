package com.kiki.domain.dto.article;

import com.kiki.domain.entities.Conditionnement;
import com.kiki.domain.entities.UniteVente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdate {
    private String refArt;

    private String desArt;

    private Double puHT;

    private Integer dg;

    private Integer md;

    private Integer mg;

    private Conditionnement conditionnement;

    private UniteVente uniteVente;
}
