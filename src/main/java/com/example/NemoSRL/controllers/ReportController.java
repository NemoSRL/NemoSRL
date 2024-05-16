package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Prodotto;
import com.example.NemoSRL.model.Report;
import com.example.NemoSRL.repository.ProdottoRepository;
import com.example.NemoSRL.services.ReportServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    @Autowired
    private ReportServices reportServices;
    @Autowired
    private ProdottoRepository prodottoRepository;

    @GetMapping
    public List<Report> getAll(){
        return reportServices.showAllreports();
    }
    @GetMapping
    @RequestMapping("/ricerca")
    public List<Report>ricerca(@RequestParam(name = "Cf_personale") String cf_personale,@RequestParam(name = "dettagli") String dettagli, @RequestParam(name ="id") Integer np, @RequestParam(name = "etichetta") Integer etichetta){
        return reportServices.showAllAvanzato(cf_personale,dettagli,np,etichetta);
    }
    @PutMapping
    public ResponseEntity create(@RequestBody Report report){
        try{
            return new ResponseEntity<>(reportServices.addReport(report), HttpStatus.OK);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",e);
        }
    }
    @DeleteMapping("/elimina")
    public ResponseEntity eliminaReport(@RequestParam(name = "id") Integer id,@RequestParam(name = "Etichetta")Integer etichetta){
        try{
           reportServices.eliminaReportPerId(id,etichetta);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
