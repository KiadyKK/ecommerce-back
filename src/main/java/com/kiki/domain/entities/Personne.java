package com.kiki.domain.entities;

import com.kiki.domain.requests.personne.SignUpRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String mdp;

    @Column
    private Boolean pending;

    @OneToMany(mappedBy = "personne")
    private List<Appro> appros;

    @OneToMany(mappedBy = "personne")
    private List<Livraison> livraisons;

    @ManyToOne
    private Role role;

    public Personne(SignUpRequest request, Role role, Boolean pending) {
        this.username = request.getUsername();
        this.mdp = BCrypt.hashpw(request.getMdp(), BCrypt.gensalt());
        this.email = request.getEmail();
        this.pending = pending;
        this.role = role;
    }
}
