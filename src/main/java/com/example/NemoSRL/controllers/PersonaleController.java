package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Personale;
import com.example.NemoSRL.services.PersonaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personale")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonaleController {
    @Autowired
    private PersonaleService personaleService;

    @GetMapping
    public List<Personale> getAllPersonale() {
        return personaleService.getAll();
    }
}
