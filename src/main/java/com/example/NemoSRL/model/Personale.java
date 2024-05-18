package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personale")
public class Personale {
    @Id
    @SequenceGenerator(name = "personale_id_gen", sequenceName = "ordineinuscita_codice_seq", allocationSize = 1)
    @Column(name = "cf", length = Integer.MAX_VALUE)
    private String cf;

    @Column(name = "nome", length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "cognome", length = Integer.MAX_VALUE)
    private String cognome;

    @Column(name = "ruolo", length = Integer.MAX_VALUE)
    private String ruolo;

    @Column(name = "telefono", length = Integer.MAX_VALUE)
    private String telefono;

}