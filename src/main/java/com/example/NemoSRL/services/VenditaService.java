package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.VenditaDTO;
import com.example.NemoSRL.model.Vendita;
import com.example.NemoSRL.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenditaService {
    @Autowired
    private VenditaRepository venditaRepository;
    public List<VenditaDTO> getAllVendite() {
        return venditaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VenditaDTO convertToDTO(Vendita vendita) {
        VenditaDTO dto = new VenditaDTO();
        dto.setNp(vendita.getId().getNp());
        dto.setData(vendita.getId().getData());
        dto.setTipologia(vendita.getTipologia());
        return dto;
    }

}
