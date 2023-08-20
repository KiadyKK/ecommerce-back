package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    @Id
    private Long id;

    @Column
    private String four;

    @Column
    private Long telFour;

    @Column
    private String addFour;

    @Column
    String emailFour;

    @OneToMany(mappedBy = "fournisseur")
    private Set<Appro> appros;
}
