package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
