package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "azienda")
public class Azienda {
    @Id
    @SequenceGenerator(name = "azienda_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
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

    @OneToMany(mappedBy = "azienda")
    private Set<Referenteaziendale> referenteaziendales = new LinkedHashSet<>();

}