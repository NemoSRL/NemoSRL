package com.example.NemoSRL.controllers;

import com.example.NemoSRL.services.OrdiniServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordini")
public class OrdineController {
    @Autowired
    private OrdiniServices ordiniServices;
    @GetMapping
    public List<Integer> getAllIds(){
        return ordiniServices.showAllOrdiniIds();
    }
}
