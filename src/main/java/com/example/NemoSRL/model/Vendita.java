package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vendita")
public class Vendita {
    @SequenceGenerator(name = "vendita_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
    @EmbeddedId
    private VenditaId id;

    @Column(name = "tipologia", length = 16)
    private String tipologia;

    @OneToMany(mappedBy = "vendita")
    private Set<Etichette> etichettes = new LinkedHashSet<>();

}