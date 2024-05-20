package com.example.NemoSRL.services;

import com.example.NemoSRL.DTO.PosizioneDTO;
import com.example.NemoSRL.model.Posizione;
import com.example.NemoSRL.repository.PosizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosizioneService {
    @Autowired
    private PosizioneRepository posizioneRepository;

    public List<PosizioneDTO> getAllPosizioni() {
        return posizioneRepository.findAllByOrderByIdAsc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PosizioneDTO convertToDTO(Posizione posizione) {
        PosizioneDTO dto = new PosizioneDTO();
        dto.setId(posizione.getId().getId());
        dto.setNp(posizione.getId().getNp());
        dto.setTipo(posizione.getTipo());
        dto.setSogliaminima(posizione.getSogliaminima());
        return dto;
    }
}
