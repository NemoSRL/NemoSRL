package com.example.NemoSRL.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "smaltimenti")
public class Smaltimenti {
    @SequenceGenerator(name = "smaltimenti_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
    @EmbeddedId
    private SmaltimentiId id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Report report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personale")
    private Personale personale;

}