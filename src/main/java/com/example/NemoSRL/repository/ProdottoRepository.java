package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
    public List<Prodotto> findAllByNome(String nome);
    public List<Prodotto> findAllByOrderByIdAsc();
    public void deleteById(int id);
    @Query("select p "+
            "from Prodotto p "+
            "WHERE (p.nome like ?1 Or ?1 is NULL) and "+
            "(p.qualita like ?2 or ?2 is null) and" +
            "(p.id = ?3 or ?3 is null ) and" +
            "(p.quantita = ?4 or ?4 is null) and "+
            "(p.sogliaminima=?5 or ?5 is null)"
            )
    public List<Prodotto> richercaAvanzata(String nome,String qualita,Integer id,Integer quantita, Integer sogliaMinima);
    public Prodotto findProdottoById(Integer id);

}