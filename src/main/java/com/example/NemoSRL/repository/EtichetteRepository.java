package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EtichetteRepository extends JpaRepository<Etichette, Integer> {
    List<Etichette> findByPeso(int kg);
    List<Etichette> findByAbbattimento(boolean abattuto);
    List<Etichette> findByDataarrivo(Date data);
    //List<Etichette> findByPosizione(int id,int np);
    List<Etichette> findByProdotto(Prodotto prodotto);
}