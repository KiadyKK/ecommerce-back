package com.kiki.models.reglement_appro.id;

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
    private String appro_facApp;

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
        ReglementApproId pk = (ReglementApproId) o;
        return Objects.equals(appro_facApp, pk.appro_facApp) &&
                Objects.equals(day_day, pk.day_day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appro_facApp, day_day);
    }
}
