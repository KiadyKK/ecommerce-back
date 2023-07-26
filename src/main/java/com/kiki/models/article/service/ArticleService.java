package com.kiki.models.article.service;

import com.kiki.models.article.request.ArticleRequest;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public interface ArticleService {
    Response create(MultipartFormDataInput input);

    Response getAll();
}
