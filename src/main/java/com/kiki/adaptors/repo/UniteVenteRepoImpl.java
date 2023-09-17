package com.kiki.adaptors.repo;

import com.kiki.domain.dto.uniteVente.UniteVenteDto;
import com.kiki.domain.entities.UniteVente;
import com.kiki.ports.secondary.UniteVenteRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UniteVenteRepoImpl implements UniteVenteRepo {
    @Override
    public UniteVente findByUtvArt(String utvArt) {
        return find("utvArt = ?1", utvArt).firstResult();
    }

    @Override
    public List<UniteVente> listByUtvArt(String utvArt) {
        return find("utvArt LIKE '%" + utvArt + "%'").list();
    }

    @Override
    public boolean removeById(long id) {
        return deleteById(id);
    }

    @Override
    public int update(UniteVenteDto uniteVenteDto) {
        return update("SET utvArt = ?1 WHERE id = ?2", uniteVenteDto.getUtvArt(), uniteVenteDto.getId());
    }
}
