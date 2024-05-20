package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Vendita;
import com.example.NemoSRL.model.VenditaId;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenditaRepository extends JpaRepository<Vendita, VenditaId> {

    List<Vendita> findAllByOrderByIdAsc();
}