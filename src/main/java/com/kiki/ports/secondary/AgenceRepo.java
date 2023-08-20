package com.kiki.ports.secondary;

import com.kiki.domain.entities.Agence;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface AgenceRepo extends PanacheRepository<Agence> {
    Agence findByAbrAgc(String abrAgc);
}
