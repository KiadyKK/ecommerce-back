package com.kiki.models.article.mapper;

import com.kiki.models.article.dto.ArticleDto;
import com.kiki.models.article.entity.Article;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleMapper {
    ArticleDto entityToDto(Article article);
}
