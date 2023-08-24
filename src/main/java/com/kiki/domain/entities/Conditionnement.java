package com.kiki.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "conditionnement")
public class Conditionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String condArt;

    @OneToMany(mappedBy = "conditionnement")
    private Set<Article> articles;

    public Conditionnement(String condArt) {
        this.condArt = condArt;
    }
}
