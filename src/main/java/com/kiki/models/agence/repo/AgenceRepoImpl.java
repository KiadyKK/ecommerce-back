package com.kiki.models.agence.repo;

import com.kiki.models.agence.entity.Agence;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenceRepoImpl implements AgenceRepo {
    @Override
    public Agence findByAbrAgc(String abrAgc) {
        return find("abrAgc = ?1", abrAgc).firstResult();
    }
}
