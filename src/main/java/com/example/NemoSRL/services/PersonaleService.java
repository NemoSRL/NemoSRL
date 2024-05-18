package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Personale;
import com.example.NemoSRL.repository.PersonaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaleService {
    @Autowired
    PersonaleRepository personaleRepository;
    public List<Personale> getAll() {return personaleRepository.findAll();}
}
