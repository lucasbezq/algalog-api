package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mapper.OcorrenciaMapper;
import com.algaworks.algalog.api.model.OcorrenciaDto;
import com.algaworks.algalog.api.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;

    @Autowired
    private OcorrenciaMapper ocorrenciaMapper;

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    public ResponseEntity<OcorrenciaDto> registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());

        return new ResponseEntity(ocorrenciaMapper.toDto(ocorrenciaRegistrada), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OcorrenciaDto>> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ResponseEntity.ok(ocorrenciaMapper.toCollectionDto(entrega.getOcorrencias()));
    }

}
