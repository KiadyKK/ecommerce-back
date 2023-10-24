package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.domain.entities.id.CaisseAgenceId;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "caisse_agence")
public class CaisseAgence {
    @EmbeddedId
    private CaisseAgenceId caisseAgenceId = new CaisseAgenceId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idAbrAgc")
    @JoinColumn(name = "idAbrAgc")
    private Agence agence;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idDay")
    @JoinColumn(name = "idDay")
    private Day day;

    @Column
    private String recDep;

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
