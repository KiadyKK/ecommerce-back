package com.kiki.models.livraison.entity;

import com.kiki.models.personne.entity.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.agence.entity.Agence;
import com.kiki.models.client.entity.Client;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "livraison")
public class Livraison {
    @Id
    private String facLiv;

    @Column
    private String noBlf;

    @Column
    private String mPay;

    @Column
    private Double totalLiv;

    @Column
    private Date dateCom;

    @Column
    private Date dateEch;

    @ManyToOne
    private Agence agence;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Personne personne;
}
