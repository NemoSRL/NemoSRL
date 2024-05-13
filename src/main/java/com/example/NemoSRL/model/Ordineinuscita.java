package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ordineinuscita")
public class Ordineinuscita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordineinuscita_id_gen")
    @SequenceGenerator(name = "ordineinuscita_id_gen", sequenceName = "ordineinuscita_codice_seq", allocationSize = 1)
    @Column(name = "codice", nullable = false)
    private Integer id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "datainvio")
    private LocalDate datainvio;

    @Column(name = "dataconsegna")
    private LocalDate dataconsegna;

    @Column(name = "stato", length = 16)
    private String stato;

    @Column(name = "tracciamento", length = Integer.MAX_VALUE)
    private String tracciamento;

    @Column(name = "indirizzoconsegna", length = Integer.MAX_VALUE)
    private String indirizzoconsegna;

    @Column(name = "corriere", length = 16)
    private String corriere;

}