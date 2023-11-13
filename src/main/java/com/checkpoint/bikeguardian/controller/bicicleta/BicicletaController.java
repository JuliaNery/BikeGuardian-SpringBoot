package com.checkpoint.bikeguardian.controller.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroBicicleta;
import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosDetalhamentoBicicleta;
import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.validacoes.ValidacaoBicicleta;
import com.checkpoint.bikeguardian.repositories.bicicleta.BicicletaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/bicicletas")
public class BicicletaController {
    @Autowired
    private ValidacaoBicicleta validacaoBicicleta;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroBicicleta dados, UriComponentsBuilder uriBuilder){
        var dto = validacaoBicicleta.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }
}
