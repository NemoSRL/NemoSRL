package com.example.NemoSRL.model;

import com.example.NemoSRL.model.*;
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
@Table(name = "etichette", schema = "public")
public class Etichette {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etichetta_id_gen")
    @SequenceGenerator(name = "etichetta_id_gen", sequenceName = "etichetta_sequence_col_name", allocationSize = 1)
    @Column(name = "codice", nullable = false)
    private Integer id;

    @Column(name = "abbattimento", nullable = false)
    private Boolean abbattimento;

    @Column(name = "dataarrivo", nullable = false)
    private LocalDate dataarrivo;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "scontoextra", nullable = false)
    private Double scontoextra;

    @Column(name = "descrizione", length = Integer.MAX_VALUE, nullable = false)
    private String descrizione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prenotazione")
    private Cliente prenotazione;






    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodotto", nullable = false)
    private Prodotto prodotto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "slotid", referencedColumnName = "pos_id", nullable = false),
            @JoinColumn(name = "slotnp", referencedColumnName = "np", nullable = false)
    })

    private Slot slot;

    @OneToMany(mappedBy = "etichetta")
    private Set<Report> reports = new LinkedHashSet<>();

}