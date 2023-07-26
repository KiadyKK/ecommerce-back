package com.kiki.models.reglement_appro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.appro.entity.Appro;
import com.kiki.models.day.entity.Day;
import com.kiki.models.reglement_appro.id.ReglementApproId;

@Getter
@Setter
@Entity
@Table(name = "reglement_appro")
public class ReglementAppro {
    @EmbeddedId
    private ReglementApproId reglementApproId = new ReglementApproId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("appro_facApp")
    private Appro appro;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("day_day")
    private Day day;

    @Column
    private Boolean etatPay;

    @Column
    private Double montantRglt;

    @Column
    private Double reste;
}
