package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime dateEch;

    @Column
    private LocalDateTime dateFac;

    @ManyToOne
    @JoinColumn(name = "idPers")
    private Personne personne;

    @OneToOne
    @JoinColumn(name = "idFacComLiv")
    private CommandeLivraison commandelivraison;
}
