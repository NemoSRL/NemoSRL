package com.example.NemoSRL.model;

import com.example.NemoSRL.model.Slot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "posizione", schema = "public")
public class Posizione {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "tipo", length = Integer.MAX_VALUE)

    private String tipo;

    @Column(name = "sogliaminima")
    private Integer sogliaminima;
    @Column(name = "luogo")
    private String luogo;

    @OneToMany(mappedBy = "pos")
    private Set<Slot> slots = new LinkedHashSet<>();
}
