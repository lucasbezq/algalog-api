package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Lucas");
        cliente1.setEmail("lucas@gmail.com");
        cliente1.setTelefone("(21)99999-9999");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Elisangela");
        cliente2.setEmail("elis@gmail.com");
        cliente2.setTelefone("(21)88888-9999");

        return Arrays.asList(cliente1, cliente2);
    }

}
