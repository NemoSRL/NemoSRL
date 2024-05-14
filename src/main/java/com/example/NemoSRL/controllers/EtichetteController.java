package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.services.EtichetteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/etichette")
public class EtichetteController {
    @Autowired
    private EtichetteServices etichetteServices;

    @GetMapping
    public List<Etichette> getAll(){
        return etichetteServices.showAllEtichets();
    }


}
