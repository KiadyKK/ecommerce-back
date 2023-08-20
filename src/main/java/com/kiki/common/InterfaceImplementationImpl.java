package com.kiki.common;

import com.kiki.adaptors.repo.*;
import com.kiki.ports.secondary.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InterfaceImplementationImpl implements InterfaceImplementation {
    @Override
    public AgenceRepo getAgenceRepo() {
        return new AgenceRepoImpl();
    }

    @Override
    public ArticleRepo getArticleRepo() {
        return new ArticleRepoImpl();
    }

    @Override
    public CategorieRepo getCategorieRepo() {
        return new CategorieRepoImpl();
    }

    @Override
    public ConditionnementRepo getConditionnementRepo() {
        return new ConditionnementRepoImpl();
    }

    @Override
    public PersonneRepo getPersonneRepo() {
        return new PersonneRepoImpl();
    }

    @Override
    public RoleRepo getRoleRepo() {
        return new RoleRepoImpl();
    }

    @Override
    public UniteVenteRepo getUniteVenteRepo() {
        return new UniteVenteRepoImpl();
    }
}
