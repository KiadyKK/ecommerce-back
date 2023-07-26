package com.kiki.models.conditionnement.repo;

import com.kiki.models.conditionnement.entity.Conditionnement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ConditionnementRepo extends PanacheRepository<Conditionnement> {
    Conditionnement findByCondArt(String condArt);
}
