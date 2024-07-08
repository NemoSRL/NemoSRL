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
    private Double scontoextra;
    private String posizioneid;
    private Integer posizionenp;
    private String posizionetipo;
    private String posizioneluogo;

    private String oldPosizioneId;
    private Integer oldPosizioneNp;
}
