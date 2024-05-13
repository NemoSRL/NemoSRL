package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "posizione")
public class Posizione {
    @SequenceGenerator(name = "posizione_id_gen", sequenceName = "ordineinuscita_codice_seq", allocationSize = 1)
    @EmbeddedId
    private PosizioneId id;

    @Column(name = "tipo", length = Integer.MAX_VALUE)
    private String tipo;

    @Column(name = "sogliaminima")
    private Double sogliaminima;

}