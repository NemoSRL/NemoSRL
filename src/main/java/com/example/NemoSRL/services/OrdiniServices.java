package com.example.NemoSRL.services;

import com.example.NemoSRL.model.Ordineinuscita;
import com.example.NemoSRL.repository.OrdineinuscitaRepository;
import com.example.NemoSRL.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdiniServices {
    @Autowired
    private OrdineinuscitaRepository ordineinuscitaRepository;
    public List<Ordineinuscita> getAll(){
              return ordineinuscitaRepository.findAllByOrderByIdAsc();


    }

}
