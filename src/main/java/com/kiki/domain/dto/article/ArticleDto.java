package com.kiki.domain.dto.article;

import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ArticleDto {
    private String refArt;

    private String desArt;

    private String imgArt;

    private String urlArt;

    private Double puHT;

    private Integer dg;

    private Integer md;

    private Integer mg;

    private Date dateArt;

    private CategorieDto categorie;

    private ConditionnementDto conditionnement;

    private UniteVenteDto uniteVente;
}
