package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Smaltimenti;
import com.example.NemoSRL.model.SmaltimentiId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmaltimentiRepository extends JpaRepository<Smaltimenti, SmaltimentiId> {
}