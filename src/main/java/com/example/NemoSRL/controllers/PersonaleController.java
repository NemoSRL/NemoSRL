package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Personale;
import com.example.NemoSRL.services.PersonaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{id}")
    public Personale getPersonale(@PathVariable String id) {
        return personaleService.getByid(id);//codice fiscale
    }
}
