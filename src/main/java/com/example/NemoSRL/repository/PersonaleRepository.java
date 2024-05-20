package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Personale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaleRepository extends JpaRepository<Personale, String> {
    List<Personale> findPersonaleByCf(String cf);
    List<Personale> findPersonaleByRuolo(String ruolo);
    List<Personale> findPersonaleByNomeAndCognome(String name,String cognome);
    List<Personale> findAllByOrderByCfAsc();
}