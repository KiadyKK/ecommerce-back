package com.kiki.models.reglement_livraison.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ReglementLivraisonId implements Serializable {
    @Column
    private String livraison_facLiv;

    @Column
    private Date day_day;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReglementLivraisonId pk = (ReglementLivraisonId) o;
        return Objects.equals(livraison_facLiv, pk.livraison_facLiv) &&
                Objects.equals(day_day, pk.day_day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livraison_facLiv, day_day);
    }
}
