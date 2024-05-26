package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.SlotDTO;
import com.example.NemoSRL.model.Posizione;
import com.example.NemoSRL.model.Prodotto;
import com.example.NemoSRL.model.Slot;
import com.example.NemoSRL.model.SlotId;
import com.example.NemoSRL.repository.PosizioneRepository;
import com.example.NemoSRL.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private PosizioneRepository posizioneRepository;

    public List<SlotDTO> showAll(String id,Boolean occupato){
        return slotRepository.findOccupati(id,occupato).stream()
                                                        .map(this::map)
                                                        .collect(Collectors.toList());
    }
    public SlotDTO showByid(String id,Integer np){
        return map(slotRepository.findById(id,np));
    }
    public SlotDTO addSlot(SlotDTO slot) throws Exception{
        Slot s = new Slot();
        SlotId sid = new SlotId();
        sid.setPosId(slot.getPosizione());
        sid.setNp(slot.getNp());
        s.setId(sid);
        s.setOccupato(slot.getOccupato());
        Posizione p=posizioneRepository.findPosizioneById(slot.getPosizione());
        s.setPosizione(p);
        Slot result= slotRepository.save(s);
        return map(result);
    }
    public void eliminaProdottoPerId(String s,Integer np){
        slotRepository.deleteById(s,np);
    }

    private SlotDTO map(Slot slot){
        SlotDTO ret = new SlotDTO();
        ret.setPosizione(slot.getId().getPosId());
        ret.setNp(slot.getId().getNp());
        ret.setOccupato(slot.getOccupato());
        return ret;
    }
}
