package com.example.NemoSRL.controllers;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.services.EtichetteServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/etichette")
public class EtichetteController {
    @Autowired
    private EtichetteServices etichetteServices;

    @GetMapping
    public List<EtichettaDTO> getAll(){
        return etichetteServices.showAll();
    }
    @GetMapping("/ricerca")
    public List<EtichettaDTO> getAllAvanzato(@RequestParam(required = false)Integer id,
                                          @RequestParam(required = false)Integer prod_id,
                                          @RequestParam(required = false)String posizione,
                                             @RequestParam(required = false) Integer peso,
                                             @RequestParam(required = false) String descrizione,
                                             @RequestParam(required = false) String prenotazione){
        return etichetteServices.showAvanzato(id,prod_id,posizione, peso, descrizione, prenotazione);
    }
    @GetMapping("/ricercaPerData/{date}")
    public List<EtichettaDTO> ricercaPerData(@PathVariable LocalDate date){
        return etichetteServices.ricercaPerData(date);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminaEtichetta(@PathVariable int id){
        try{
            etichetteServices.elimina(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public EtichettaDTO ricercaPerId(@PathVariable Integer id){
        return etichetteServices.showEtichettaById(id);
    }
    @GetMapping("/ricercaPer/{data}")
    public List<EtichettaDTO> recercaPerData(@PathVariable LocalDate data){
        return etichetteServices.ricercaPerData(data);
    }
    @PostMapping
    public ResponseEntity create(@RequestBody EtichettaDTO e){
        try{
            return new ResponseEntity<>(etichetteServices.addEtichetta(e), HttpStatus.OK);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",ex);
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody EtichettaDTO e){
        try{
            return new ResponseEntity<>(etichetteServices.addEtichetta(e), HttpStatus.OK);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",ex);
        }
    }
}
