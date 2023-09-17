package com.kiki.ports.secondary;

import com.kiki.domain.dto.conditionnement.ConditionnementDto;
import com.kiki.domain.entities.Conditionnement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface ConditionnementRepo extends PanacheRepository<Conditionnement> {
    Conditionnement findByCondArt(String condArt);

    List<Conditionnement> listByCondArt(String condArt);

    boolean removeById(long id);

    int update(ConditionnementDto conditionnementDto);
}
