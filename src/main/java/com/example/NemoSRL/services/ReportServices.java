package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Report;
import com.example.NemoSRL.repository.EtichetteRepository;
import com.example.NemoSRL.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServices {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> showAllreports(){
        return reportRepository.findAll();
    }
}
