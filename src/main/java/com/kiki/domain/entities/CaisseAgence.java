package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.domain.entities.id.CaisseAgenceId;

@Getter
@Setter
@Entity
@Table(name = "caisse_agence")
public class CaisseAgence {
    @EmbeddedId
    private CaisseAgenceId caisseAgenceId = new CaisseAgenceId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("agence_abrAgc")
    private Agence agence;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("day_day")
    private Day day;

    @Column
    private String r_d;

    @Column
    private String noFac;

    @Column
    private String refTiers;

    @Column
    private String motif;

    @Column
    private Double montant;

    @Column
    private Double total;
}
