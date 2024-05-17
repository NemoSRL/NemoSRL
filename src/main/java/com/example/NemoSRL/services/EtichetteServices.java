package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.repository.EtichetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EtichetteServices {
    @Autowired
    private EtichetteRepository etichetteRepository;

    public List<Etichette> showAllEtichets(){
         return etichetteRepository.findAll();
    }
    public List<Etichette> showAvanzato(Integer id, Integer prod_id, String posizione, Date data_Arrivo, Integer ordine, Integer vendita){
       return etichetteRepository.fidnAvanzato(id,prod_id,posizione,data_Arrivo,ordine,vendita);
    }
    public void elimina(Integer id){
        etichetteRepository.deleteById(id);
    }
    public Etichette addEtichetta(Etichette e){
        return etichetteRepository.save(e);
    }
}
