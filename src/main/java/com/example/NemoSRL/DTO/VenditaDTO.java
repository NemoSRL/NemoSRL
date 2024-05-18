package com.example.NemoSRL.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VenditaDTO {
    private Integer np;
    private LocalDate data;
    private String tipologia;


}
