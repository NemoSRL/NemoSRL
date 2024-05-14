package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.repository.EtichetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtichetteServices {
    @Autowired
    private EtichetteRepository etichetteRepository;

    public List<Etichette> showAllEtichets(){
        return etichetteRepository.findAll();
    }
}
