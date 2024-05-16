package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Ordineinuscita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrdineinuscitaRepository extends JpaRepository<Ordineinuscita, Integer> {

    List<Ordineinuscita> findById(int codice);
    //List<Ordineinuscita> findByReferenteazienda(String cf);
}