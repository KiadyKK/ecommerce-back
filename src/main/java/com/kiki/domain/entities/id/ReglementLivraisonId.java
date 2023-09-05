package com.kiki.domain.entities.id;

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
    private String idFacLiv;

    @Column
    private Date idDay;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReglementLivraisonId pk = (ReglementLivraisonId) o;
        return Objects.equals(idFacLiv, pk.idFacLiv) &&
                Objects.equals(idDay, pk.idDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacLiv, idDay);
    }
}
