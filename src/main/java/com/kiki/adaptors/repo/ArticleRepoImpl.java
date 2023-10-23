package com.kiki.adaptors.repo;

import com.kiki.domain.requests.article.ArticleUpdateRequest;
import com.kiki.domain.entities.Article;
import com.kiki.ports.secondary.ArticleRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ArticleRepoImpl implements ArticleRepo {
    @Override
    public Article findByRefArt(String refArt) {
        return find("refArt = ?1", refArt).firstResult();
    }

    @Override
    public List<Article> getAll(String catArt, String condArt, String utvArt, String desArt) {
        return find("categorie.catArt LIKE '%" + catArt + "%' AND conditionnement.condArt LIKE '%" + condArt + "%'" +
                " AND uniteVente.utvArt LIKE '%" + utvArt + "%' AND desArt LIKE '%" + desArt + "%'").list();
    }

    @Override
    public long removeByRef(String refArt) {
        return delete("refArt = ?1", refArt);
    }

    @Override
    public int updateByRef(ArticleUpdateRequest articleUpdate) {
        return update("""
                desArt = ?1,
                puHT = ?2,
                dg = ?3,
                md = ?4,
                mg = ?5,
                conditionnement = ?6,
                uniteVente = ?7 WHERE
                refArt = ?8
                """, articleUpdate.getDesArt(), articleUpdate.getPuHT(), articleUpdate.getDg(), articleUpdate.getMd(),
                articleUpdate.getMg(), articleUpdate.getConditionnement(), articleUpdate.getUniteVente(), articleUpdate.getRefArt());
    }
}
