package com.kiki.models.conditionnement.repo;

import com.kiki.models.conditionnement.entity.Conditionnement;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConditionnementRepoImpl implements ConditionnementRepo {
    @Override
    public Conditionnement findByCondArt(String condArt) {
        return find("condArt = ?1", condArt).firstResult();
    }
}
