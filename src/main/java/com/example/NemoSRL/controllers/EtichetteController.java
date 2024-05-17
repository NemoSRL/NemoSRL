package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Prodotto;
import com.example.NemoSRL.services.EtichetteServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/etichette")
public class EtichetteController {
    @Autowired
    private EtichetteServices etichetteServices;

    @GetMapping
    public List<Etichette> getAll(){
        return etichetteServices.showAllEtichets();
    }
    @GetMapping("/ricerca")
    public List<Etichette> getAllAvanzato(@RequestParam(required = false)Integer id,
                                          @RequestParam(required = false)Integer prod_id,
                                          @RequestParam(required = false)String posizione,
                                          @RequestParam(required = false)Date data_Arrivo,
                                          @RequestParam(required = false)Integer ordine,
                                          @RequestParam(required = false)Integer vendita){
        return etichetteServices.showAvanzato(id,prod_id,posizione,data_Arrivo,ordine,vendita);
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
    @PutMapping
    public ResponseEntity create(@RequestBody Etichette e){
        try{
            return new ResponseEntity<>(etichetteServices.showAllEtichets().add(e), HttpStatus.OK);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",ex);
        }
    }


}
