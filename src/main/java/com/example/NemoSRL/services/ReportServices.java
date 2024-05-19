package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.ReportDTO;
import com.example.NemoSRL.model.*;
import com.example.NemoSRL.repository.EtichetteRepository;
import com.example.NemoSRL.repository.PersonaleRepository;
import com.example.NemoSRL.repository.ReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServices {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> showAllreports(){
        return reportRepository.findAll();
    }

    public Report addReport(ReportDTO report) throws Exception{
        return updateReport(report);
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
    @Autowired
    private EtichetteRepository etichetteRepository;

    @Autowired
    private PersonaleRepository personaleRepository;

    @Transactional

    public Report updateReport(ReportDTO reportDTO) {
            ReportId reportId = new ReportId();
            reportId.setNp(reportDTO.getNp());
            reportId.setEtichetta(reportDTO.getEtichetta());

            Optional<Report> optionalReport = reportRepository.findById(reportId);
            if (!optionalReport.isPresent()) {
                throw new RuntimeException("Report not found");
            }

            Report report = optionalReport.get();
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
}
