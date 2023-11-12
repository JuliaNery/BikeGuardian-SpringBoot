package com.checkpoint.bikeguardian.controller.cliente;

import com.checkpoint.bikeguardian.controller.cliente.DTO.DadosCadastroCliente;
import com.checkpoint.bikeguardian.controller.cliente.DTO.DadosDetalhamentoCliente;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoCobAdc;
import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import com.checkpoint.bikeguardian.repositories.cliente.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new ClienteEntity(dados);

        clienteRepository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getCpfCliente()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCliente>> listar(){
        var cliente = clienteRepository.findAll().stream().map(DadosDetalhamentoCliente :: new).collect(Collectors.toList());
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}
