package com.kiki.models.reglement_livraison.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.day.entity.Day;
import com.kiki.models.livraison.entity.Livraison;
import com.kiki.models.reglement_livraison.id.ReglementLivraisonId;

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
}
