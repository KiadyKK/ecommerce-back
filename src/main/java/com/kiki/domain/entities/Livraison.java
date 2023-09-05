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
    @JoinColumn(name = "idAbrAgc")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "idClt")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idPers")
    private Personne personne;
}
