package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime dateFac;

    @Column
    private LocalDateTime dateEch;

    @ManyToOne
    @JoinColumn(name = "idPers")
    private Personne personne;

    @OneToOne
    @JoinColumn(name = "idFacComApp")
    private CommandeAppro commandeappro;
}
