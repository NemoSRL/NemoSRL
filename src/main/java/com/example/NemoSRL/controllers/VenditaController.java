package com.example.NemoSRL.controllers;

import com.example.NemoSRL.DTO.VenditaDTO;
import com.example.NemoSRL.model.Vendita;
import com.example.NemoSRL.services.VenditaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendite")
@CrossOrigin
public class VenditaController {
    @Autowired
    VenditaService venditaService;
    @GetMapping
    public List<VenditaDTO> getAll() {
        return venditaService.getAllVendite();
    }

}
