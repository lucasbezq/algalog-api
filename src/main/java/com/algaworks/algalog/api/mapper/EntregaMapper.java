package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.model.EntregaDto;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EntregaDto toDto(Entrega entrega) {
        return modelMapper.map(entrega, EntregaDto.class);
    }

    public List<EntregaDto> toCollectionDto(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput) {
        return modelMapper.map(entregaInput, Entrega.class);
    }

}
