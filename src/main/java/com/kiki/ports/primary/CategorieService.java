package com.kiki.ports.primary;

import com.kiki.domain.dto.categorie.CategorieDto;
import com.kiki.domain.requests.categorie.CategorieRequest;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface CategorieService {
    Response.Status create(CategorieRequest request);

    List<CategorieDto> getAll();
}
