package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.kiki.domain.entities.Personne;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;

    @OneToMany(mappedBy = "role")
    private List<Personne> personnes;

    public Role(String role) {
        this.role = role;
    }
}
