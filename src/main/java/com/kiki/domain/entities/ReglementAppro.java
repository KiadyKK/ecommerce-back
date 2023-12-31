package com.kiki.domain.entities;

import com.kiki.domain.entities.id.ReglementApproId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    private Agence agence;
}
