package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prezzointerno")
public class Prezzointerno {
    @SequenceGenerator(name = "prezzointerno_id_gen", sequenceName = "ordineinuscita_codice_seq", allocationSize = 1)
    @EmbeddedId
    private PrezzointernoId id;

    @Column(name = "valore")
    private Double valore;

    @Column(name = "unitamisura", length = Integer.MAX_VALUE)
    private String unitamisura;

    @Column(name = "sconto")
    private Double sconto;

}