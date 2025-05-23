package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Ordineinuscita;
import com.example.NemoSRL.services.OrdiniServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordini")
@CrossOrigin
public class OrdineController {
    @Autowired
    private OrdiniServices ordiniServices;
    @GetMapping
    public List<Ordineinuscita> getAll(){
        return ordiniServices.getAll();
    }
}
