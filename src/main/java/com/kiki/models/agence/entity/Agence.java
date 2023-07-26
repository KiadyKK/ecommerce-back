package com.kiki.models.agence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.appro.entity.Appro;
import com.kiki.models.livraison.entity.Livraison;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "agence")
public class Agence {
    @Id
    @GeneratedValue
    private String abrAgc;

    @Column
    private String agc;

    @Column
    private Long telAgc;

    @Column
    private String addAgc;

    @OneToMany(mappedBy = "agence")
    private List<Appro> appros;

    @OneToMany(mappedBy = "agence")
    private List<Livraison> livraisons;
}
