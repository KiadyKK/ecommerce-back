package com.kiki.ports.primary;

import com.kiki.domain.dto.agence.AgenceDto;
import com.kiki.domain.requests.agence.AgenceRequest;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface AgenceService {
    Response.Status create(AgenceRequest request);

    List<AgenceDto> getAll();
}
