package com.kiki.ports.primary;

import com.kiki.domain.dto.article.ArticleDto;
import com.kiki.domain.dto.article.ArticleUpdate;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import java.io.File;
import java.util.List;

public interface ArticleService {
    Response.Status create(MultipartFormDataInput input);

    List<ArticleDto> getAll(String catArt, String condArt, String utvArt, String desArt);

    File download(String img);

    String removeByRef(String  refArt);

    ArticleDto update(ArticleUpdate articleUpdate);
}
