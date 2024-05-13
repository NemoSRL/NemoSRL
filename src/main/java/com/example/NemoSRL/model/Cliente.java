package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @SequenceGenerator(name = "cliente_id_gen", sequenceName = "etichette_codice_seq", allocationSize = 1)
    @Column(name = "cf", nullable = false, length = Integer.MAX_VALUE)
    private String cf;

    @Column(name = "nome", length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "cognome", length = Integer.MAX_VALUE)
    private String cognome;

    @Column(name = "telefono", length = Integer.MAX_VALUE)
    private String telefono;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "\"età\"")
    private Integer età;

    @Column(name = "sesso", length = Integer.MAX_VALUE)
    private String sesso;

    @OneToMany(mappedBy = "prenotazione")
    private Set<Etichette> etichettes = new LinkedHashSet<>();

    @OneToOne(mappedBy = "cf")
    private Referenteaziendale referenteaziendale;

}