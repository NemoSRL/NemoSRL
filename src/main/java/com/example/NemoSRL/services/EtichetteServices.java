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
    private PosizioneRepository posizioneRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private OrdineinuscitaRepository ordineinuscitaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Etichette> showAllEtichets(){
         return etichetteRepository.findAll();
    }
    public List<EtichettaDTO> showAvanzato(Integer id, Integer prod_id, String posizione, LocalDate data_Arrivo, Integer ordine, Integer vendita, Integer peso, String descrizione, String prenotazione){
       return etichetteRepository.fidnAvanzato(id,prod_id,posizione,data_Arrivo,ordine,vendita, peso, descrizione, prenotazione).stream().map(this::mapper).collect(Collectors.toList());
    }
    public void elimina(Integer id){
        etichetteRepository.deleteById(id);
    }
    public Etichette addEtichetta(EtichettaDTO e){
        Etichette r = new Etichette();
        if(!(e.getPosizioneid() == null || e.getPosizionenp() == null)) {
            Posizione pos = posizioneRepository.findById_IdAndId_Np(e.getPosizioneid(), e.getPosizionenp());
            r.setPosizione(pos);
        }
        if(!(e.getVenditadata()==null || e.getVenditanp() == null)){
            r.setVenditadata(e.getVenditadata());
            r.setVenditanp(e.getVenditanp());
        }
        if (e.getOrdineUscita() != null) {
            Optional<Ordineinuscita> ordineinuscita = ordineinuscitaRepository.findById(e.getOrdineUscita());
            ordineinuscita.ifPresent(r::setOrdineinuscita);
        }

        if (e.getProdotto() != null) {
            Optional<Prodotto> prodotto = prodottoRepository.findById(e.getProdotto());
            prodotto.ifPresent(r::setProdotto);
        }
        if (e.getPrenotazione() != null) {
            Optional<Cliente> cliente = clienteRepository.findById(e.getPrenotazione());
            cliente.ifPresent(r::setPrenotazione);
        }



        r.setProdotto(prodottoRepository.findProdottoById(e.getProdotto()));
        r.setId(e.getId());
        r.setDataarrivo(e.getDataarrivo());
        r.setDescrizione(e.getDescrizione());
        r.setAbbattimento(e.getAbbattimento());
        r.setPeso(e.getPeso());
        r.setVenditanp(e.getVenditanp());
        r.setVenditadata(e.getVenditadata());
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
