package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoCobAdcSeguro;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroCobAdcSeguro;
import com.checkpoint.bikeguardian.entities.seguro.validacoes.ValidacaoCobAdcSeguro;
import com.checkpoint.bikeguardian.repositories.seguro.CobAdcSeguroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cobadcseguro")
public class CobAdcSeguroController {

    @Autowired
    ValidacaoCobAdcSeguro validacaoCobAdcSeguro;

    @Autowired
    CobAdcSeguroRepository cobAdcSeguroRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCobAdcSeguro dados){
        var dto = validacaoCobAdcSeguro.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCobAdcSeguro>> listar(){
        var cobAdcSeguro = cobAdcSeguroRepository.findAll().stream().map(DadosDetalhamentoCobAdcSeguro :: new).collect(Collectors.toList());
        return ResponseEntity.ok(cobAdcSeguro);
    }
}
