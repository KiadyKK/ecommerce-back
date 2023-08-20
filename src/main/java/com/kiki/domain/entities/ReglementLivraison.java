package com.kiki.domain.entities;

import com.kiki.domain.entities.id.ReglementLivraisonId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reglement_livraison")
public class ReglementLivraison {
    @EmbeddedId
    private ReglementLivraisonId reglementLivraisonId = new ReglementLivraisonId();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("livraison_facLiv")
    private Livraison livraison;

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
    private Client client;
}
