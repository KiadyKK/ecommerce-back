package com.kiki.domain.entities.id;

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
    private String idFacLiv;

    @Column
    private String idRefArt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LivraisonArticleId pk = (LivraisonArticleId) o;
        return Objects.equals(idFacLiv, pk.idFacLiv) &&
                Objects.equals(idRefArt, pk.idRefArt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacLiv, idRefArt);
    }
}
