package com.example.NemoSRL.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ReportDTO {
    private Integer np;
    private Integer etichetta;
    private LocalDate data;
    private String dettagli;
    private String personale;
    private Integer oldEtichetta;
    private String tipo;
    private boolean spostato;
}
