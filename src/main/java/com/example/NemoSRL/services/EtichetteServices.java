package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Posizione;
import com.example.NemoSRL.model.PosizioneId;
import com.example.NemoSRL.repository.EtichetteRepository;
import com.example.NemoSRL.repository.PosizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtichetteServices {
    @Autowired
    private EtichetteRepository etichetteRepository;
    @Autowired
    private PosizioneRepository posizioneRepository;
    public List<Etichette> showAllEtichets(){
         return etichetteRepository.findAll();
    }
    public List<Etichette> showAvanzato(Integer id, Integer prod_id, String posizione, LocalDate data_Arrivo, Integer ordine, Integer vendita){
       return etichetteRepository.fidnAvanzato(id,prod_id,posizione,data_Arrivo,ordine,vendita);
    }
    public void elimina(Integer id){
        etichetteRepository.deleteById(id);
    }
    public Etichette addEtichetta(Etichette e){
        return etichetteRepository.save(e);
    }
    public Etichette updateEtichetta(Etichette e){return etichetteRepository.save(e);}
    public List<EtichettaDTO> ricercaPerData(LocalDate data){
        return etichetteRepository.findEtichettesByDataarrivo(data).stream().map(this::mapper).collect(Collectors.toList());
    }

    public List<EtichettaDTO>  showAll(){
        return etichetteRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());
    }
    public EtichettaDTO showEtichettaById(Integer id) {
        return mapper( etichetteRepository.findEtichetteById(id));
    }
    private EtichettaDTO mapper(Etichette e){
        EtichettaDTO r = new EtichettaDTO();
        Posizione p = posizioneRepository.findById_IdAndId_Np(e.getPosizione(), e.getPosizioneNp());
        if (p == null) {
            r.setPosizionetipo(null);
        } else {
            r.setPosizionetipo(p.getTipo());
        }
        if (e.getProdotto() != null) {
            r.setProdotto(e.getProdotto().getId());
        }
        r.setId(e.getId());
        r.setDataarrivo(e.getDataarrivo());
        r.setDescrizione(e.getDescrizione());
        r.setAbbattimento(e.getAbbattimento());
        r.setPeso(e.getPeso());
        r.setVenditanp(e.getVenditanp());
        r.setPosizioneid(e.getPosizione());
        r.setPosizionenp(e.getPosizioneNp());
        r.setVenditadata(e.getVenditadata());
        if (e.getOrdineinuscita() != null) {
            r.setOrdineUscita(e.getOrdineinuscita().getId());
        }
        r.setScontoextra(e.getScontoextra());
        return r;
    }
}
