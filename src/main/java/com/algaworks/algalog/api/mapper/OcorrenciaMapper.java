package com.algaworks.algalog.api.mapper;

import com.algaworks.algalog.api.model.OcorrenciaDto;
import com.algaworks.algalog.domain.model.Ocorrencia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OcorrenciaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OcorrenciaDto toDto(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaDto.class);
    }

    public List<OcorrenciaDto> toCollectionDto(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
