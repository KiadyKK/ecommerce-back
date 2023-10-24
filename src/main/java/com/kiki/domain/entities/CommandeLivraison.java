package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "commandelivraison")
public class CommandeLivraison {
    @Id
    private String facComLiv;

    @Column
    private String noBcl;

    @Column
    private String mpay;

    @Column
    private Double totalLiv;

    @Column
    private LocalDateTime dateCom;

    @ManyToOne
    @JoinColumn(name = "idAbrAgc")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "idClt")
    private Client client;

    @OneToOne(mappedBy = "commandelivraison")
    private Livraison livraison;
}
