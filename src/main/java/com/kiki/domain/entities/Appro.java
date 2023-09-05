package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appro")
public class Appro {
    @Id
    private String facApp;

    @Column
    private String noBa;

    @Column
    private String mPay;

    @Column
    private Double totalApp;

    @Column
    private Date dateCom;

    @Column
    private Date dateEch;

    @ManyToOne
    @JoinColumn(name = "idAbrAgc")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "idFour")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "idPers")
    private Personne personne;
}
