package com.kiki.domain.entities;

import com.kiki.domain.requests.agence.AgenceRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "agence")
public class Agence {
    @Id
    private String abrAgc;

    @Column
    private String agc;

    @Column
    private Long telAgc;

    @Column
    private String addAgc;

    @OneToMany(mappedBy = "agence")
    private Set<Appro> appros;

    @OneToMany(mappedBy = "agence")
    private Set<Livraison> livraisons;

    @OneToMany(mappedBy = "agence")
    private Set<ReglementAppro> reglementAppro;

    public Agence(AgenceRequest request) {
        this.abrAgc = request.getAbrAgc();
        this.agc = request.getAgc();
        this.telAgc = request.getTelAgc();
        this.addAgc = request.getAddAgc();
    }
}
