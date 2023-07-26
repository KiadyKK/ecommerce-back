package com.kiki.models.appro.entity;

import com.kiki.models.personne.entity.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.agence.entity.Agence;
import com.kiki.models.fournisseur.entity.Fournisseur;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appro")
public class Appro {
    @Id
    @GeneratedValue
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
    private Agence agence;

    @ManyToOne
    private Fournisseur fournisseur;

    @ManyToOne
    private Personne personne;
}
