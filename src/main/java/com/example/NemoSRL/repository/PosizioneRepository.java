package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Posizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PosizioneRepository extends JpaRepository<Posizione, String> {

    List<Posizione> findAll();
<<<<<<< Updated upstream
    Posizione findById_IdAndId_Np(String id, Integer np);
=======
    List<Posizione> findAllByOrderByIdAsc();
    Optional<Posizione> findById(String id);
>>>>>>> Stashed changes

    //List<Posizione> findById(int np);
    List<Posizione> findPosizioneByTipo(String tipo);

   /* @Query( "SELECT codice  " +
            "FROM Etichette e,Prodotto p " +
            "WHERE e.prodotto.id=p.id AND" +
            " p.qualita=?1 AND e.posizione.id=?2")//qualita non c'e
    List<Etichette> searcTipologiaDiQualita(String qualita, int pos);*/
}