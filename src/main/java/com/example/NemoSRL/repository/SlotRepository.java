package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Slot;
import com.example.NemoSRL.model.SlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, SlotId> {
    @Query("select s " +
            "from Slot s " +
            "where s.id.posId=?1 and s.id.np =?2 and s.occupato = ?3 ")
    public Slot findSlotByOccupato(String posizione,Integer np,Boolean occupato);
    @Query("select s " +
            "from Slot s " +
            "where s.id.posId=?1 and s.id.np =?2 ")
    public Slot findById(String pos,Integer np);
    public Slot findSlotById(SlotId id);
    @Query("select s " +
            "from Slot s " +
            "WHERE (LOWER(s.id.posId) like LOWER( concat('%',?1,'%') ) or ?1 is null) and " +
            "(s.occupato = ?2 or ?2 is null )")
    public List<Slot> findOccupati(String id,Boolean occupato);

    @Query("select s " +
            "from Slot s " +
            "where s.id.posId=?1 and s.id.np =?2 ")
    public void deleteById(String id,Integer np);
}