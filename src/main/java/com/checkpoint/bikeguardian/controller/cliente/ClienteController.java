package com.checkpoint.bikeguardian.controller.cliente;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroCor;
import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosDetalhamentoCor;
import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import com.checkpoint.bikeguardian.entities.endereco.Endereco;
import com.checkpoint.bikeguardian.repositories.cliente.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

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

}
