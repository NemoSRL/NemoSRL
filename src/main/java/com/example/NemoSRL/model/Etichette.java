package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "etichette")
public class Etichette {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etichette_id_gen")
    @SequenceGenerator(name = "etichette_id_gen", sequenceName = "etichette_codice_seq", allocationSize = 1)
    @Column(name = "codice", nullable = false)
    private Integer id;

    @Column(name = "dataarrivo")
    private LocalDate dataarrivo;

    @Column(name = "descrizione", length = Integer.MAX_VALUE)
    private String descrizione;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "abbattimento")
    private Boolean abbattimento;

    @Column(name = "scontoextra")
    private Double scontoextra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prenotazione")
    private Cliente prenotazione;

}