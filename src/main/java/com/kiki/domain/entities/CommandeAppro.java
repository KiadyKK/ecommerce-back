package com.kiki.domain.entities;

import com.kiki.domain.entities.Agence;
import com.kiki.domain.entities.Appro;
import com.kiki.domain.entities.Fournisseur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "commandeappro")
public class CommandeAppro {
    @Id
    private String facComApp;

    @Column
    private String noBca;

    @Column
    private String mpay;

    @Column
    private Double totalApp;

    @Column
    private LocalDateTime dateCom;

    @ManyToOne
    @JoinColumn(name = "idAbrAgc")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "idFour")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "idPers")
    private Personne personne;

    @OneToOne(mappedBy = "commandeappro")
    private Appro appro;
}
