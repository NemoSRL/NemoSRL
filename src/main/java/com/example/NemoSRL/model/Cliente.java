package com.example.NemoSRL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
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

    @Column(name = "eta")
    private Integer eta;

    @Column(name = "sesso", length = Integer.MAX_VALUE)
    private String sesso;

}