package com.checkpoint.bikeguardian.controller.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import com.checkpoint.bikeguardian.repositories.bicicleta.MarcaRepository;
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
@RequestMapping(value = "/marcas")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMarca dados, UriComponentsBuilder uriBuilder){
        var marca = new MarcaEntity(dados);
        marcaRepository.save(marca);
        var uri = uriBuilder.path("/marcas/{id}").buildAndExpand(marca.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMarca(marca));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoMarca>> listar(){
        var marca = marcaRepository.findAll().stream().map(DadosDetalhamentoMarca :: new).collect(Collectors.toList());
        return ResponseEntity.ok(marca);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var marca = marcaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMarca(marca));
    }
}
