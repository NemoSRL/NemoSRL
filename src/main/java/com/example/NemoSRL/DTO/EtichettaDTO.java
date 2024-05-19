package com.example.NemoSRL.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EtichettaDTO {
    private Integer id;
    private LocalDate dataarrivo;
    private String descrizione;
    private Boolean abbattimento;
    private Double peso;
    private Integer prodotto;
    private Integer venditanp;
    private LocalDate venditadata;
    private Integer ordineUscita;
    private Double scontoextra;
    private String posizioneid;
    private Integer posizionenp;
    private String posizionetipo;
    private String prenotazione;
}
