package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "referenteaziendale")
public class Referenteaziendale {
    @Id
    @SequenceGenerator(name = "referenteaziendale_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
    @Column(name = "cf", nullable = false, length = Integer.MAX_VALUE)
    private String cf;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cf", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "azienda")
    private Azienda azienda;

    @Column(name = "telefonoaziendale", length = Integer.MAX_VALUE)
    private String telefonoaziendale;

    @Column(name = "emailaziendale", length = Integer.MAX_VALUE)
    private String emailaziendale;

}