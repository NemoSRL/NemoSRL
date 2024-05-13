package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Personale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaleRepository extends JpaRepository<Personale, String> {
}