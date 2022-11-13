package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.api.model.EntregaDto;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @Autowired
    private EntregaMapper entregaMapper;

    @PostMapping
    public ResponseEntity<EntregaDto> solicitar(@Valid @RequestBody EntregaInput entregaInput) {
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return new ResponseEntity(entregaMapper.toDto(entregaSolicitada), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EntregaDto> listar() {
        return entregaMapper.toCollectionDto(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable  Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toDto(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

}
