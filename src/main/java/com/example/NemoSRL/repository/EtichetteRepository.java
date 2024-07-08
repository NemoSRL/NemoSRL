package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EtichetteRepository extends JpaRepository<Etichette, Integer> {
    List<Etichette> findAllByOrderByIdAsc();
    List<Etichette> findByPeso(int kg);
    List<Etichette> findByAbbattimento(boolean abattuto);
    List<Etichette> findByDataarrivo(Date data);
    //List<Etichette> findByPosizione(int id,int np);
    List<Etichette> findByProdotto(Prodotto prodotto);
//    @Query("select e.id, e.dataarrivo,e.descrizione,e.abbattimento,e.peso,e.prodotto.id,e.venditanp,e.venditadata,e.ordineinuscita.id,e.scontoextra,e.posizione.id,e.prenotazione.cf " +
//            "from Etichette  e ")
//    @Override
//    public List<Etichette> findAll();
    @Query("SELECT e " +
            "from Etichette e " +
            "WHERE (e.id=?1 or ?1 is null ) and " +
            "(e.prodotto.id =?2 or ?2 is null ) and" +
            "(e.slot.id.posId like ?3 or ?3 is null ) and " +
            "(e.peso = ?4 or ?4 is null) and"+
            "(e.descrizione = ?5 or ?5 is null) and"+
            "(e.prenotazione = ?6 or ?6 is null)"
    )
    public List<Etichette> fidnAvanzato(Integer id, Integer prod_id, String posizione,
                                        Integer peso, String descrizione, String prenotazione);
    public List<Etichette> findEtichettesByDataarrivo(LocalDate data);
    public void deleteById(Integer id);
    public Etichette findEtichetteById(Integer id);
}