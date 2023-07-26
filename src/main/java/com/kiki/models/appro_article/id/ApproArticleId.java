package com.kiki.models.appro_article.id;

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
public class ApproArticleId implements Serializable {
    @Column
    private String appro_facApp;

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
        ApproArticleId pk = (ApproArticleId) o;
        return Objects.equals(appro_facApp, pk.appro_facApp) &&
                Objects.equals(article_refArt, pk.article_refArt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appro_facApp, article_refArt);
    }
}
