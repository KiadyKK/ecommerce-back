package com.kiki.adaptors.repo;

import com.kiki.domain.entities.Agence;
import com.kiki.domain.requests.agence.AgenceRequest;
import com.kiki.ports.secondary.AgenceRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AgenceRepoImpl implements AgenceRepo {
    @Override
    public Agence findByAbrAgc(String abrAgc) {
        return find("abrAgc = ?1", abrAgc).firstResult();
    }

    @Override
    public List<Agence> listByAgc(String agc) {
        return find("agc LIKE '%" + agc + "%'").list();
    }

    @Override
    public long removeByAbr(String abrAgc) {
        return delete("abrAgc = ?1", abrAgc);
    }

    @Override
    public int updateByAbr(AgenceRequest request) {
        return update("""
                agc = ?1,
                telAgc = ?2,
                addAgc = ?3,
                mdp = ?4 WHERE
                abrAgc = ?5
                """, request.getAgc(), request.getTelAgc(), request.getAddAgc(),
                request.getMdp(), request.getAbrAgc());
    }
}
