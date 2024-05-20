package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Cliente;
import com.example.NemoSRL.model.Referenteaziendale;
import com.example.NemoSRL.repository.ClienteRepository;
import com.example.NemoSRL.repository.ReferenteaziendaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ReferenteaziendaleRepository referenteaziendaleRepository;

    public List<String> showAllClientiCf(){
        List<String> cfClienti = clienteRepository.findAll().stream()
                .map(Cliente::getCf)
                .collect(Collectors.toList());
        return cfClienti;
    }
    public List<String> showAllReferentiCf(){
        List<String> cfReferente = referenteaziendaleRepository.findAll().stream()
                .map(Referenteaziendale::getCf)
                .collect(Collectors.toList());
        return cfReferente;
    }
    public List<Cliente> showAllClienti(){
        return clienteRepository.findAllByOrderByCfAsc();
    }

}
