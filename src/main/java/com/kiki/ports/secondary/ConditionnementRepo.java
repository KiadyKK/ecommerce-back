package com.kiki.ports.secondary;

import com.kiki.domain.entities.Conditionnement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ConditionnementRepo extends PanacheRepository<Conditionnement> {
    Conditionnement findByCondArt(String condArt);
}
