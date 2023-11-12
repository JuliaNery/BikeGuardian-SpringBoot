package com.checkpoint.bikeguardian.controller.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroModelo;
import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosDetalhamentoModelo;
import com.checkpoint.bikeguardian.entities.bicicleta.ModeloEntity;
import com.checkpoint.bikeguardian.repositories.bicicleta.ModeloRepository;
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
@RequestMapping(value = "/modelos")
public class ModeloController {

    @Autowired
    ModeloRepository modeloRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroModelo dados, UriComponentsBuilder uriBuilder){
        var modelo = new ModeloEntity(dados);
        modeloRepository.save(modelo);
        var uri = uriBuilder.path("/modelos/{id}").buildAndExpand(modelo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoModelo(modelo));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoModelo>> listar(){
        var modelo = modeloRepository.findAll()
                                     .stream()
                                     .map(DadosDetalhamentoModelo :: new).collect(Collectors.toList());
        return ResponseEntity.ok(modelo);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var modelo = modeloRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoModelo(modelo));
    }
}
