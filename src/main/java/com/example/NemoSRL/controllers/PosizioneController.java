package com.example.NemoSRL.controllers;

import com.example.NemoSRL.DTO.PosizioneDTO;
import com.example.NemoSRL.services.PosizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posizioni")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PosizioneController {
    @Autowired
    private PosizioneService posizioneService;
    @GetMapping
    public List<PosizioneDTO> getAll(){
        return posizioneService.getAllPosizioni();
    }
    @GetMapping("/tipi")
    public List<String> getAllTipi(){return posizioneService.getAlltipi();}
}
