package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroCobAdc;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoCobAdc;
import com.checkpoint.bikeguardian.entities.seguro.CobAdcEntity;
import com.checkpoint.bikeguardian.repositories.seguro.CobAdcRepository;
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
@RequestMapping("/cobadc")
public class CobAdcController {

    @Autowired
    private CobAdcRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCobAdc dados, UriComponentsBuilder uriBuilder){
        var cobAdc = new CobAdcEntity(dados);
        repository.save(cobAdc);
        var uri = uriBuilder.path("/marcas/{id}").buildAndExpand(cobAdc.getIdCobAdc()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCobAdc(cobAdc));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCobAdc>> listar(){
        var cobAdc = repository.findAll().stream().map(DadosDetalhamentoCobAdc :: new).collect(Collectors.toList());
        return ResponseEntity.ok(cobAdc);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cobAdc = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCobAdc(cobAdc));
    }
}
