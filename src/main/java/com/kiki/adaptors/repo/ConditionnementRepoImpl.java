package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Conditionnement;
import com.kiki.ports.secondary.ConditionnementRepo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConditionnementRepoImpl implements ConditionnementRepo {
    @Override
    public Conditionnement findByCondArt(String condArt) {
        return find("condArt = ?1", condArt).firstResult();
    }
}
