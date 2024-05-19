package com.example.NemoSRL.controllers;

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
import java.util.Date;
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

    @GetMapping
    @RequestMapping("/ricerca")
    public List<Report> ricerca(@RequestParam(name = "cf_personale", required = false) String cf_personale,
                                @RequestParam(name = "dettagli", required = false) String dettagli,
                                @RequestParam(name = "id", required = false) Integer np,
                                @RequestParam(name = "etichetta", required = false) Integer etichetta,
                                @RequestParam(name="data", required = false) String data ){
        String[] d=data.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
        System.out.println(date + " " + date.getClass().getName());
        return reportServices.showAllAvanzato(cf_personale, dettagli, np, etichetta, date);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ReportDTO report) {
        try {
            return new ResponseEntity<>(reportServices.addReport(report), HttpStatus.OK);
        } catch (Exception e) {
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

}
