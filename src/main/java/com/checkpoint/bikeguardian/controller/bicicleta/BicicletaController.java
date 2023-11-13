package com.checkpoint.bikeguardian.controller.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroBicicleta;
import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosDetalhamentoBicicleta;
import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.validacoes.ValidacaoBicicleta;
import com.checkpoint.bikeguardian.entities.seguro.validacoes.DadosDetalhamentoSeguro;
import com.checkpoint.bikeguardian.repositories.bicicleta.BicicletaRepository;
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

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bicicletas")
public class BicicletaController {
    @Autowired
    private ValidacaoBicicleta validacaoBicicleta;

    @Autowired
    private BicicletaRepository bicicletaRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroBicicleta dados, UriComponentsBuilder uriBuilder){
        var dto = validacaoBicicleta.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoBicicleta>> listar(){
        var bicicleta = bicicletaRepository.findAll().stream().map(DadosDetalhamentoBicicleta :: new).collect(Collectors.toList());
        return ResponseEntity.ok(bicicleta);
    }
}
