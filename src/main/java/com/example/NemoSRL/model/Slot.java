package com.example.NemoSRL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "slot", schema = "public")
public class Slot {
    @EmbeddedId
    private SlotId id;

    @MapsId("posId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pos_id", nullable = false)
    @JsonIgnore
    private Posizione pos;

    @Column(name = "occupato")
    private Boolean occupato;

//    @ManyToOne(optional = false)
//    private Posizione posizione;

//    public Posizione getPosizione() {
//        return pos;
//    }

    public void setPosizione(Posizione posizione) {
        this.pos = posizione;
    }
}