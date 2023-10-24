package com.kiki.ports.secondary;

import com.kiki.domain.entities.Agence;
import com.kiki.domain.requests.agence.AgenceRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface AgenceRepo extends PanacheRepository<Agence> {
    Agence findByAbrAgc(String abrAgc);

    List<Agence> listByAgc(String agc);

    long removeByAbr(String abrAgc);

    int updateByAbr(AgenceRequest request);

    Agence findByAbr(String abrAgc);
}
