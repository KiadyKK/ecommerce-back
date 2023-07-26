package com.kiki.models.article.dto;

import com.kiki.models.categorie.dto.CategorieDto;
import com.kiki.models.conditionnement.dto.ConditionnementDto;
import com.kiki.models.uniteVente.dto.UniteVenteDto;
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

    private Integer mD;

    private Integer mG;

    private Date dateArt;

    private CategorieDto categorie;

    private ConditionnementDto conditionnement;

    private UniteVenteDto uniteVente;
}
