package com.kiki.domain.mappers;

import com.kiki.domain.dto.article.ArticleDto;
import com.kiki.domain.entities.Article;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleMapper {
    ArticleDto entityToDto(Article article);
}
