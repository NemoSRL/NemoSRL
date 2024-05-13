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
@Table(name = "azienda")
public class Azienda {
    @Id
    @Column(name = "piva", nullable = false, length = Integer.MAX_VALUE)
    private String piva;

    @Column(name = "ragionesociale", length = Integer.MAX_VALUE)
    private String ragionesociale;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "reputazione", length = Integer.MAX_VALUE)
    private String reputazione;

    @Column(name = "citta", length = Integer.MAX_VALUE)
    private String citta;

}