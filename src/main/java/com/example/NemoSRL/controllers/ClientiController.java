package com.example.NemoSRL.controllers;

import com.example.NemoSRL.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClientiController {
    @Autowired
    private ClienteServices clienteServices;
    @RequestMapping("/referenti")
    @GetMapping
    public List<String> getAllReferentiCf(){
        return clienteServices.showAllReferentiCf();
    }
    @GetMapping List<String> getAllClientiCf(){
        return clienteServices.showAllClientiCf();
    }
}
