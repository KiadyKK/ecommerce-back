package com.kiki.domain.entities;

import com.kiki.domain.requests.agence.AgenceRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

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
    private String telAgc;

    @Column
    private String addAgc;

    @Column
    private String mdp;

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
        this.mdp = request.getMdp();
    }
}
