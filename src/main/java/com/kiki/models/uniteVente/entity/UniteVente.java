package com.kiki.models.uniteVente.entity;

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
@Table(name = "uniteVente")
public class UniteVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String utvArt;

    @OneToMany(mappedBy = "uniteVente")
    private List<Article> articles;

    public UniteVente(String utvArt) {
        this.utvArt = utvArt;
    }
}
