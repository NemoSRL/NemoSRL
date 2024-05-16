package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "posizione")
    private Set<Etichette> etichettes = new LinkedHashSet<>();

}