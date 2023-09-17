package com.kiki.adaptors.repo;

import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.entities.Conditionnement;
import com.kiki.ports.secondary.ConditionnementRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ConditionnementRepoImpl implements ConditionnementRepo {
    @Override
    public Conditionnement findByCondArt(String condArt) {
        return find("condArt = ?1", condArt).firstResult();
    }

    @Override
    public List<Conditionnement> listByCondArt(String condArt) {
        return find("condArt LIKE '%" + condArt + "%'").list();
    }

    @Override
    public boolean removeById(long id) {
        return deleteById(id);
    }

    @Override
    public int update(ConditionnementDto conditionnementDto) {
        return update("SET condArt = ?1 WHERE id = ?2", conditionnementDto.getCondArt(), conditionnementDto.getId());
    }
}
