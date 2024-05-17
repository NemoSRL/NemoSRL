package com.example.NemoSRL.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

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


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JsonIgnore
    @JoinColumns({
            @JoinColumn(name = "posizioneid", referencedColumnName = "id"),
            @JoinColumn(name = "posizionenp", referencedColumnName = "np")
    })
    private Posizione posizione;

    @Column(name = "venditanp")
    private Integer venditanp;

    @Column(name = "venditadata")
    private LocalDate venditadata;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordineinuscita")
    private Ordineinuscita ordineinuscita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodotto")
    private Prodotto prodotto;

    @JsonIgnore
    @OneToMany(mappedBy = "etichetta")
    private Set<Report> reports = new LinkedHashSet<>();

}