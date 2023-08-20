package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Agence;
import com.kiki.ports.secondary.AgenceRepo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenceRepoImpl implements AgenceRepo {
    @Override
    public Agence findByAbrAgc(String abrAgc) {
        return find("abrAgc = ?1", abrAgc).firstResult();
    }
}
