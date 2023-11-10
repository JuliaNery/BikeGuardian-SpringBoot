package com.checkpoint.bikeguardian.controller.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import com.checkpoint.bikeguardian.repositories.bicicleta.CorRepository;
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
@RequestMapping(value = "/cores")
public class CorController {
    @Autowired
    private CorRepository corRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCor dados, UriComponentsBuilder uriBuilder){
        var cor = new CorEntity(dados);
        corRepository.save(cor);
        var uri = uriBuilder.path("/marcas/{id}").buildAndExpand(cor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCor(cor));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCor>> listar(){
        var cor = corRepository.findAll().stream().map(DadosDetalhamentoCor :: new).collect(Collectors.toList());
        return ResponseEntity.ok(cor);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cor = corRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCor(cor));
    }
}
