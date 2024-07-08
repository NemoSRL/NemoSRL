package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Cliente;
import com.example.NemoSRL.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;


    public List<String> showAllClientiCf(){
        List<String> cfClienti = clienteRepository.findAll().stream()
                .map(Cliente::getCf)
                .collect(Collectors.toList());
        return cfClienti;
    }

    public List<Cliente> showAllClienti(){
        return clienteRepository.findAllByOrderByCfAsc();
    }

}
