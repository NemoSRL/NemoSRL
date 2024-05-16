package com.example.NemoSRL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {
    @SequenceGenerator(name = "report_id_gen", sequenceName = "qualità_column_name_seq", allocationSize = 1)
    @EmbeddedId
    @JsonUnwrapped
    private ReportId id;

    @MapsId("etichetta")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etichetta", nullable = false)
    private Etichette etichetta;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "dettagli", length = Integer.MAX_VALUE)
    private String dettagli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personale")
    private Personale personale;

}