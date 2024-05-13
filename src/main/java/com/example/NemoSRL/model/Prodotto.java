package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodotto_id_gen")
    @SequenceGenerator(name = "prodotto_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
    @Column(name = "codice", nullable = false)
    private Integer id;

    @Column(name = "nome", length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "sogliaminima")
    private Double sogliaminima;

    @Column(name = "quantita")
    private Double quantita;

}