package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Prodotto;
import com.example.NemoSRL.services.ProdottoServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/prodotti")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdottoController {
    @Autowired
    ProdottoServices prodottoServices;

   /* @GetMapping
    public List<Prodotto> getAll(){
        return prodottoServices.showAllProducts();
    }*/
    @GetMapping
    public List<Prodotto> getAll(){
        return prodottoServices.showAllProducts();

    }
    @PutMapping
    public ResponseEntity create(@RequestBody Prodotto prod){
        try{
            return new ResponseEntity<>(prodottoServices.addProdotto(prod), HttpStatus.OK);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",e);
        }
    }

    @RequestMapping("/{id}")
    @DeleteMapping

    public ResponseEntity eliminaProdotto(@PathVariable int id){
        try{
            prodottoServices.eliminaProdottoPerId(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
