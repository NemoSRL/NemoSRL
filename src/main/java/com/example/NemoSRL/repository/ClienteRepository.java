package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}