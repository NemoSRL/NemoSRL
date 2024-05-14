package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
    public List<Prodotto> findAllByNome(String nome);
}