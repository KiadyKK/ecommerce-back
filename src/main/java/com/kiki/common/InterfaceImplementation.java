package com.kiki.common;

import com.kiki.ports.secondary.*;

public interface InterfaceImplementation {
    AgenceRepo getAgenceRepo();

    ArticleRepo getArticleRepo();

    CategorieRepo getCategorieRepo();

    ConditionnementRepo getConditionnementRepo();

    PersonneRepo getPersonneRepo();

    RoleRepo getRoleRepo();

    UniteVenteRepo getUniteVenteRepo();
}
