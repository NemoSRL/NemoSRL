package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.model.*;
import com.example.NemoSRL.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtichetteServices {
    @Autowired
    private EtichetteRepository etichetteRepository;
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private PosizioneRepository posizioneRepository;

    public List<Etichette> showAllEtichets(){
         return etichetteRepository.findAll();
    }
    public List<EtichettaDTO> showAvanzato(Integer id, Integer prod_id, String posizione, Integer peso, String descrizione){
       return etichetteRepository.fidnAvanzato(id,prod_id,posizione, peso, descrizione).stream().map(this::mapper).collect(Collectors.toList());
    }
    public void elimina(Integer id){
        etichetteRepository.deleteById(id);
    }
    public Etichette addEtichetta(EtichettaDTO e){
        Etichette r = new Etichette();
        if(!e.getPosizioneid().equals(e.getOldPosizioneId()) && !e.getPosizionenp().equals(e.getOldPosizioneNp())){
            Slot oldSlot=slotRepository.findById(e.getOldPosizioneId(),e.getOldPosizioneNp());
            oldSlot.setOccupato(false);
        }
        if(!(e.getPosizioneid() == null )) {
            Slot s = slotRepository.findById(e.getPosizioneid(),e.getPosizionenp());
            s.setOccupato(true);
            r.setSlot(s);
        }



        if (e.getProdotto() != null) {
            Optional<Prodotto> prodotto = prodottoRepository.findById(e.getProdotto());
            prodotto.ifPresent(r::setProdotto);
        }




        r.setProdotto(prodottoRepository.findProdottoById(e.getProdotto()));
        r.setId(e.getId());
        r.setDataarrivo(e.getDataarrivo());
        r.setDescrizione(e.getDescrizione());
        r.setAbbattimento(e.getAbbattimento());
        r.setPeso(e.getPeso());
        r.setScontoextra(e.getScontoextra());

        return etichetteRepository.save(r);
    }
    public Etichette updateEtichetta(Etichette e){return etichetteRepository.save(e);}
    public List<EtichettaDTO> ricercaPerData(LocalDate data){
        return etichetteRepository.findEtichettesByDataarrivo(data).stream().map(this::mapper).collect(Collectors.toList());
    }

    public List<EtichettaDTO>  showAll(){
        return etichetteRepository.findAllByOrderByIdAsc().stream().map(this::mapper).collect(Collectors.toList());
    }
    public EtichettaDTO showEtichettaById(Integer id) {
        return mapper( etichetteRepository.findEtichetteById(id));
    }
    private EtichettaDTO mapper(Etichette e){
        EtichettaDTO r = new EtichettaDTO();

        Slot s = slotRepository.findSlotById(e.getSlot().getId());
        if (s == null) {
            r.setPosizionetipo(null);
        } else {
            Posizione p = posizioneRepository.findPosizioneById(s.getId().getPosId());
            r.setPosizionetipo(p.getTipo());
            r.setPosizioneluogo(p.getLuogo());
            r.setPosizioneid(p.getId());
        }
        if (e.getProdotto() != null) {
            r.setProdotto(e.getProdotto().getId());
        }
        r.setId(e.getId());
        r.setDataarrivo(e.getDataarrivo());
        r.setDescrizione(e.getDescrizione());
        r.setAbbattimento(e.getAbbattimento());
        r.setPeso(e.getPeso());
        if(s!=null){
        r.setPosizionenp(s.getId().getNp());
        r.setPosizioneid(s.getId().getPosId());
        }

        r.setScontoextra(e.getScontoextra());
        return r;
    }
}
