package com.example.NemoSRL.controllers;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.DTO.ReportDTO;
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


import java.time.LocalDate;
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
    public List<ReportDTO> getAll() {
        return reportServices.showAllreports();
    }
    @CrossOrigin
    @GetMapping
    @RequestMapping("/ricerca")
    public List<Report> ricerca(@RequestParam(name = "cf_personale", required = false) String cf_personale,
                                @RequestParam(name = "dettagli", required = false) String dettagli,
                                @RequestParam(name = "id", required = false) Integer np,
                                @RequestParam(name = "etichetta", required = false) Integer etichetta
                                ){

        return reportServices.showAllAvanzato(cf_personale, dettagli, np, etichetta);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ReportDTO report) {
        try {
            return new ResponseEntity<>(reportServices.addReport(report), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Errore", e);
        }
    }

    @DeleteMapping("/elimina")
    public ResponseEntity eliminaReport(@RequestParam(name = "id") Integer id, @RequestParam(name = "Etichetta") Integer etichetta) {
        try {
            reportServices.eliminaReportPerId(id, etichetta);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ReportDTO report) {
        System.out.println(report.toString());
        try {
            return new ResponseEntity<>(reportServices.updateReport(report), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Errore", e);
        }
    }
    @CrossOrigin
    @GetMapping("/ricercaPer/{data}")
    public List<ReportDTO> recercaPerData(@PathVariable LocalDate data){
        return reportServices.ricercaPerData(data);
    }

}
