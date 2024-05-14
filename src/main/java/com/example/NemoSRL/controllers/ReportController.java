package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Report;
import com.example.NemoSRL.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    @Autowired
    private ReportServices reportServices;
    @GetMapping
    public List<Report> getAll(){
        return reportServices.showAllreports();
    }
}
