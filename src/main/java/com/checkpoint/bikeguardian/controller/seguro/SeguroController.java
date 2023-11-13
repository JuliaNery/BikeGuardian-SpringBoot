package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroSeguro;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoSeguro;
import com.checkpoint.bikeguardian.entities.seguro.validacoes.ValidacaoSeguro;
import com.checkpoint.bikeguardian.repositories.seguro.SeguroRepository;
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
@RequestMapping("/seguros")
public class SeguroController {
    @Autowired
    ValidacaoSeguro validacaoSeguro;

    @Autowired
    SeguroRepository seguroRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroSeguro dados){
        var dto = validacaoSeguro.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoSeguro>> listar(){
        var seguro = seguroRepository.findAll().stream().map(DadosDetalhamentoSeguro :: new).collect(Collectors.toList());
        return ResponseEntity.ok(seguro);
    }
}
