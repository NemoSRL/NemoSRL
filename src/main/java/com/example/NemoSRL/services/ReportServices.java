package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Prodotto;
import com.example.NemoSRL.model.Report;
import com.example.NemoSRL.repository.EtichetteRepository;
import com.example.NemoSRL.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServices {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> showAllreports(){
        return reportRepository.findAll();
    }
    public List<Report> showAllAvanzato(){

    }
    public Report addProdotto(Report report) throws Exception{
        Report result= reportRepository.save(report);
        return result;
    }
    public void eliminaProdottoPerId(Integer ip,Integer etichetta_id){
        reportRepository.deleteById_NpOrId_Etichetta(ip,etichetta_id);
    }
    public List<Report> showAllAvanzato(String cf_personale,String dettagli,Integer np,Integer etichetta){
        return reportRepository.richercaAvanzata(cf_personale,dettagli,np,etichetta);
    }
    public Etichette etichettaDelReport(Integer np, Integer etichetta){
        return reportRepository.richercaEtichetta(np,etichetta);
    }
}
