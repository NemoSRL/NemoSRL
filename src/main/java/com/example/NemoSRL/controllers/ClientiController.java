package com.example.NemoSRL.controllers;

import com.example.NemoSRL.model.Cliente;
import com.example.NemoSRL.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clienti")
@CrossOrigin
public class ClientiController {
    @Autowired
    private ClienteServices clienteServices;

    @GetMapping
    List<Cliente> getAllClienti() {
        return clienteServices.showAllClienti();
    }
}
