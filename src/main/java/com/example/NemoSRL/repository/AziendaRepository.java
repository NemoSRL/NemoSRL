package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, String> {

    List<Azienda> findByCittaLike(String citta);
    List<Azienda> findByRagionesocialeLike(String ragioneSociale);
    List<Azienda> findByPivaLike(String azienda);
}