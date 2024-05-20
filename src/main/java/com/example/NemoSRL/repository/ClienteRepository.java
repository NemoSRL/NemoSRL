package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ref.Cleaner;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    List<Cliente> findByNomeAndCognome(String nome, String cogniome);
    List<Cliente> findByCf(String cf);
    List<Cliente> findByNome(String nome);
    List<Cliente> findByCognome(String cognome);
    List<Cliente> findByEta(int eta);
    List<Cliente> findAllByOrderByCfAsc();
}