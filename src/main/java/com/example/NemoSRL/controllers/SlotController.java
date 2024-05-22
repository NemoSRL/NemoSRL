package com.example.NemoSRL.controllers;

import com.example.NemoSRL.DTO.EtichettaDTO;
import com.example.NemoSRL.DTO.SlotDTO;
import com.example.NemoSRL.model.Slot;
import com.example.NemoSRL.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {
    @Autowired
    SlotService slotService;
    @GetMapping("/ricerca")
    public List<SlotDTO> ricercaPerid(@RequestParam String id,@RequestParam Boolean occupato){
        return slotService.showAll(id,occupato);
    }
    @PostMapping
    public ResponseEntity create(@RequestBody SlotDTO s){
        try{
            return new ResponseEntity<>(slotService.addSlot(s), HttpStatus.OK);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",ex);
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody SlotDTO s){
        try{
            return new ResponseEntity<>(slotService.addSlot(s), HttpStatus.OK);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore",ex);
        }
    }
    @GetMapping
    public SlotDTO ricercaPerId(@RequestParam String id,@RequestParam Integer np){
        return slotService.showByid(id,np);
    }
}
