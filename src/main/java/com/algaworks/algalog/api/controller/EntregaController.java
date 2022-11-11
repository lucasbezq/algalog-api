package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.model.DestinatarioDto;
import com.algaworks.algalog.api.model.EntregaDto;
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

    @PostMapping
    public ResponseEntity<Entrega> solicitar(@Valid @RequestBody Entrega entrega) {
        return new ResponseEntity(solicitacaoEntregaService.solicitar(entrega), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable  Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaDto entregaDto = new EntregaDto();
                    entregaDto.setId(entrega.getId());
                    entregaDto.setNomeCliente(entrega.getCliente().getNome());
                    entregaDto.setDestinatario(new DestinatarioDto());
                    entregaDto.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    entregaDto.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaDto.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                    entregaDto.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                    entregaDto.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    entregaDto.setFrete(entrega.getTaxa());
                    entregaDto.setStatus(entrega.getStatus());
                    entregaDto.setDataPedido(entrega.getDataPedido());
                    entregaDto.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok(entregaDto);
                }).orElse(ResponseEntity.notFound().build());
    }

}
