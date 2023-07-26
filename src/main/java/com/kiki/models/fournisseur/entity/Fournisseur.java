package com.kiki.models.fournisseur.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.appro.entity.Appro;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String four;

    @Column
    private Long telFour;

    @Column
    private String addFour;

    @Column String emailFour;

    @OneToMany(mappedBy = "fournisseur")
    private List<Appro> appros;
}
