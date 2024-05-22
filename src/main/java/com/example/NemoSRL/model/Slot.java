package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "slot", schema = "public")
public class Slot {
    @EmbeddedId
    private SlotId id;

    @MapsId("posId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pos_id", nullable = false)//attenzione
    private Posizione pos;

    @Column(name = "occupato")
    private Boolean occupato;

    @OneToMany(mappedBy = "slot")
    private Set<Etichette> etichettes = new LinkedHashSet<>();

}