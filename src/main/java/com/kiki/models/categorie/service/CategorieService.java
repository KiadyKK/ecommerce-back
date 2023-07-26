package com.kiki.models.categorie.service;

import com.kiki.models.categorie.request.CategorieRequest;
import jakarta.ws.rs.core.Response;

public interface CategorieService {
    Response create(CategorieRequest request);

    Response getAll();
}
