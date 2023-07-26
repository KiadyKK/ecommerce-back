package com.kiki.models.agence.repo;

import com.kiki.models.agence.entity.Agence;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface AgenceRepo extends PanacheRepository<Agence> {
    Agence findByAbrAgc(String abrAgc);
}
