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
    @MapsId("idFacLiv")
    @JoinColumn(name = "idFacLiv")
    private Livraison livraison;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idDay")
    @JoinColumn(name = "idDay")
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
