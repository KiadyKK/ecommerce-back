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
public class ReglementApproId implements Serializable {
    @Column
    private String idFacApp;

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
        ReglementApproId pk = (ReglementApproId) o;
        return Objects.equals(idFacApp, pk.idFacApp) &&
                Objects.equals(idDay, pk.idDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacApp, idDay);
    }
}
