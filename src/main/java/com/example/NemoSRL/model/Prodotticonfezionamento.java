package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prodotticonfezionamento")
public class Prodotticonfezionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodotticonfezionamento_id_gen")
    @SequenceGenerator(name = "prodotticonfezionamento_id_gen", sequenceName = "prodotticonfezionamento_codice_seq", allocationSize = 1)
    @Column(name = "codice", nullable = false)
    private Integer id;

    @Column(name = "nome", length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "quantita")
    private Integer quantita;

    @Column(name = "sogliaminima")
    private Integer sogliaminima;

}