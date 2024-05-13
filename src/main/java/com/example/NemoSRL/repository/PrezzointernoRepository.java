package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Prezzointerno;
import com.example.NemoSRL.model.PrezzointernoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrezzointernoRepository extends JpaRepository<Prezzointerno, PrezzointernoId> {
    List<Prezzointerno> findPrezzointernoByValore(double prezzo);

    @Query("SELECT p "+
            "FROM Prezzointerno p "+
            "WHERE p.id.prodotto=?1"
    )
    List<Prezzointerno> findPrezzointernoByProd(int prodId);
}