package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Posizione;
import com.example.NemoSRL.model.PosizioneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosizioneRepository extends JpaRepository<Posizione, PosizioneId> {
}