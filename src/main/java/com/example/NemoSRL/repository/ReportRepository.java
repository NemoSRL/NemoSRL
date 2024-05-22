package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Etichette;
import com.example.NemoSRL.model.Report;
import com.example.NemoSRL.model.ReportId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, ReportId> {
    public List<Report> findAllByOrderByIdAsc();
    public void deleteById_NpOrId_Etichetta(Integer id_np,Integer etichetta_id);
    @Query("select r "+
            "from  Report r "+
            "WHERE ( r.personale.cf like ?1 Or ?1 is NULL) and "+
            "(r.dettagli like ?2 or ?2 is null) and" +
            "(r.id.np = ?3 or ?3 is null ) and " +
            "(r.id.etichetta=?4 or ?4 is null )"
    )
    public List<Report> ricercaAvanzata(String cf_personale, String dettagli, Integer np,Integer etichetta);
    @Query("select e "+
            "from  Report r, Etichette e "+
            "WHERE r.etichetta.id=?2 and  r.id=?1 "

    )
    public Etichette richercaEtichetta(Integer id_report, Integer id_etichetta);
    public  List<Report> findReportByData(LocalDate date);
    @Query("SELECT MAX(r.id.np) FROM Report r WHERE r.id.etichetta = :etichetta")
    Integer findMaxNpByEtichetta(@Param("etichetta") Integer etichetta);

    @Override
    void deleteById(ReportId reportId);
}