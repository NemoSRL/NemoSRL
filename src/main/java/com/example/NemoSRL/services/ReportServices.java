package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.DTO.ReportDTO;
import com.example.NemoSRL.model.*;
import com.example.NemoSRL.repository.EtichetteRepository;
import com.example.NemoSRL.repository.PersonaleRepository;
import com.example.NemoSRL.repository.ReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServices {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private EtichetteRepository etichetteRepository;
    @Autowired
    private PersonaleRepository personaleRepository;

    public List<ReportDTO> showAllreports(){
        List<ReportDTO> ret = new ArrayList<>();
        for(Report r : reportRepository.findAll()){
            ret.add(map(r));
        }
        return ret;
    }

    public Report addReport(ReportDTO reportDTO) throws Exception{
        ReportId reportId = new ReportId();
        reportId.setEtichetta(reportDTO.getEtichetta());
        reportId.setNp(generateNewId(reportDTO.getEtichetta()));
        Report report = new Report();
        report.setId(reportId);
        report.setData(reportDTO.getData());
        report.setDettagli(reportDTO.getDettagli());

        if (reportDTO.getEtichetta() != null) {
            Optional<Etichette> etichette = etichetteRepository.findById(reportDTO.getEtichetta());
            etichette.ifPresent(report::setEtichetta);
        }

        if (reportDTO.getPersonale() != null) {
            Optional<Personale> personale = personaleRepository.findById(reportDTO.getPersonale());
            personale.ifPresent(report::setPersonale);
        }

        return reportRepository.save(report);
    }
    public List<ReportDTO> ricercaPerData(LocalDate data){
        return reportRepository.findReportByData(data).stream().map(this::map).collect(Collectors.toList());
    }
    public void eliminaReportPerId(Integer ip,Integer etichetta_id){
        reportRepository.deleteById_NpOrId_Etichetta(ip,etichetta_id);
    }
    public List<Report> showAllAvanzato(String cf_personale,String dettagli,Integer np,Integer etichetta, LocalDate data){
        return reportRepository.ricercaAvanzata(cf_personale,dettagli,np,etichetta, data);
    }
    public Etichette etichettaDelReport(Integer np, Integer etichetta){
        return reportRepository.richercaEtichetta(np,etichetta);
    }



    public Report updateReport(ReportDTO reportDTO) {
            ReportId reportId = new ReportId();
            reportId.setNp(reportDTO.getNp());
            reportId.setEtichetta(reportDTO.getOldEtichetta());



            Report report = new Report();
            if(reportDTO.getEtichetta()!= reportDTO.getOldEtichetta() ){
                reportRepository.deleteById(reportId);
                reportId.setNp(generateNewId(reportDTO.getEtichetta()));
                reportId.setEtichetta(reportDTO.getEtichetta());
            }
            report.setId(reportId);
            report.setData(reportDTO.getData());
            report.setDettagli(reportDTO.getDettagli());

            if (reportDTO.getEtichetta() != null) {
                Optional<Etichette> etichette = etichetteRepository.findById(reportDTO.getEtichetta());
                etichette.ifPresent(report::setEtichetta);
            }

            if (reportDTO.getPersonale() != null) {
                Optional<Personale> personale = personaleRepository.findById(reportDTO.getPersonale());
                personale.ifPresent(report::setPersonale);
            }

            return reportRepository.save(report);

    }
    private ReportDTO map(Report r){
        ReportDTO ret = new ReportDTO();
        ret.setData(r.getData());
        ret.setDettagli(r.getDettagli());
        ret.setPersonale(r.getPersonale().getCf());
        ret.setNp(r.getId().getNp());
        ret.setEtichetta(r.getEtichetta().getId());
        return ret;
    }
    private Integer generateNewId(Integer e){

        Integer np = reportRepository.findMaxNpByEtichetta(e)+1;
        return np;
    }
}
