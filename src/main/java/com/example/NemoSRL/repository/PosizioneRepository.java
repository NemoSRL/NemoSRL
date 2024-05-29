package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Posizione;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosizioneRepository extends JpaRepository<Posizione, String> {

    List<Posizione> findAll();
    List<Posizione> findAllByOrderByIdAsc();
    Posizione findPosizioneById(String id);
    @Query("select distinct p.tipo " +
            "from Posizione p " )
    List<String> findAllByTipo();

    //List<Posizione> findById(int np);
    List<Posizione> findPosizioneByTipo(String tipo);

   /* @Query( "SELECT codice  " +
            "FROM Etichette e,Prodotto p " +
            "WHERE e.prodotto.id=p.id AND" +
            " p.qualita=?1 AND e.posizione.id=?2")//qualita non c'e
    List<Etichette> searcTipologiaDiQualita(String qualita, int pos);*/
}