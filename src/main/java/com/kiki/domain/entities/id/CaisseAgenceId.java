package com.kiki.domain.entities.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class CaisseAgenceId implements Serializable {
    @Column
    private String agence_abrAgc;

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
        CaisseAgenceId pk = (CaisseAgenceId) o;
        return Objects.equals(agence_abrAgc, pk.agence_abrAgc) &&
                Objects.equals(day_day, pk.day_day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agence_abrAgc, day_day);
    }
}
