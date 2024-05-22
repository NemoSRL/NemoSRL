package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Slot;
import com.example.NemoSRL.model.SlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, SlotId> {

    public Slot findSlotByPosAndAndPosAndOccupato(String posizione,Integer np,Boolean occupato);
    public Slot findById(String pos,Integer np);
    public Slot findSlotById(SlotId id);
    @Query("select s " +
            "from Slot s " +
            "WHERE (s.id.posId like ?1 or ?1 is null) and " +
            "(s.occupato = ?2 or ?2 is null )")
    public List<Slot> findOccupati(String id,Boolean occupato);

    public void deleteById(String id,Integer np);
}