package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Posizione;
import com.example.NemoSRL.model.PosizioneId;
import com.example.NemoSRL.repository.EtichetteRepository;
import com.example.NemoSRL.repository.PosizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EtichetteServices {
    @Autowired
    private EtichetteRepository etichetteRepository;
    @Autowired
    private PosizioneRepository posizioneRepository;
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
    public Etichette updateEtichetta(Etichette e){return etichetteRepository.save(e);}

    public List<EtichettaDTO>  showAll(){
        List<Etichette> lista = etichetteRepository.findAll();
        List<EtichettaDTO> ritorna = new ArrayList<EtichettaDTO>();
        for(Etichette e : lista){
            Posizione p = posizioneRepository.findById_IdAndId_Np(e.getPosizione(), e.getPosizioneNp());
            EtichettaDTO temp = new EtichettaDTO();
            temp.setId(e.getId());
            temp.setPeso(e.getPeso());
            temp.setPosizioneid(e.getPosizione());
            temp.setPosizionenp(e.getPosizioneNp());
            if(p ==null){
                temp.setPosizionetipo(null);
            }else {

            temp.setPosizionetipo(p.getTipo());
            }

            ritorna.add(temp);



        }

    return ritorna;
    }
}
