package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Vendita;
import com.example.NemoSRL.model.VenditaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenditaRepository extends JpaRepository<Vendita, VenditaId> {

}