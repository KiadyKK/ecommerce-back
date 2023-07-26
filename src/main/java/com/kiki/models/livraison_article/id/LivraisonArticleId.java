package com.kiki.models.livraison_article.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class LivraisonArticleId implements Serializable {
    @Column
    private String livraison_facLiv;

    @Column
    private String article_refArt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LivraisonArticleId pk = (LivraisonArticleId) o;
        return Objects.equals(livraison_facLiv, pk.livraison_facLiv) &&
                Objects.equals(article_refArt, pk.article_refArt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livraison_facLiv, article_refArt);
    }
}
