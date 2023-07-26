package com.kiki.models.conditionnement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.kiki.models.article.entity.Article;

import java.util.List;

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
    private List<Article> articles;

    public Conditionnement(String condArt) {
        this.condArt = condArt;
    }
}
