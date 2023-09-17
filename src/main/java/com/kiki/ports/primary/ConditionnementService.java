package com.kiki.ports.primary;

import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.requests.conditionnement.ConditionnementRequest;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface ConditionnementService {
    Response create(ConditionnementRequest request);

    List<ConditionnementDto> getAll(String condArt);

    int removeById(long id);

    ConditionnementDto update(ConditionnementDto conditionnementDto);
}
