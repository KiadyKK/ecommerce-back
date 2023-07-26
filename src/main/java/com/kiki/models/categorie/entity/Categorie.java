package com.kiki.models.categorie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.article.entity.Article;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String catArt;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}
