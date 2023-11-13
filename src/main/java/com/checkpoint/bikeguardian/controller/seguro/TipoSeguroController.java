package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroTipoSeguro;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoTipoSeguro;
import com.checkpoint.bikeguardian.entities.seguro.TipoSeguroEntity;
import com.checkpoint.bikeguardian.repositories.seguro.TipoSeguroRepository;
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
@RequestMapping("/tiposeguro")
public class TipoSeguroController {
    @Autowired
    private TipoSeguroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTipoSeguro dados, UriComponentsBuilder uriBuilder){
        var tipoSeguro = new TipoSeguroEntity(dados);
        repository.save(tipoSeguro);
        var uri = uriBuilder.path("/tiposeguro/{id}").buildAndExpand(tipoSeguro.getIdTipoSeguro()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTipoSeguro(tipoSeguro));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTipoSeguro>> listar(){
        var tipoSeguro = repository.findAll().stream().map(DadosDetalhamentoTipoSeguro :: new).collect(Collectors.toList());
        return ResponseEntity.ok(tipoSeguro);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var tipoSeguro = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTipoSeguro(tipoSeguro));
    }
}
