package com.kiki.models.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.kiki.models.livraison.entity.Livraison;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String clt;

    @Column
    private Long telClt;

    @Column
    private String addClt;

    @Column
    private String emailClt;

    @OneToMany(mappedBy = "client")
    private List<Livraison> livraisons;
}
