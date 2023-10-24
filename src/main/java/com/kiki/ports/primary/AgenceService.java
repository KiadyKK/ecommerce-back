package com.kiki.ports.primary;

import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.requests.agence.AgenceRequest;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface AgenceService {
    Response create(AgenceRequest request);

    List<AgenceDto> getAll(String agc);

    String removeByAbr(String abrAgc);

    AgenceDto update(AgenceRequest request);

    AgenceDto getByAbr(String abrAgc);
}
