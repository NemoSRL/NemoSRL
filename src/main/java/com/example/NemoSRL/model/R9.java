package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "r9")
public class R9 {
    @SequenceGenerator(name = "r9_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
    @EmbeddedId
    private R9Id id;

    @MapsId("prodotto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prodotto", nullable = false)
    private Prodotto prodotto;

    @MapsId("confezione")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "confezione", nullable = false)
    private Prodotticonfezionamento confezione;

}