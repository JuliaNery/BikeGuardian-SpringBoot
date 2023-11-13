package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroMeioPag;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoMeioPag;
import com.checkpoint.bikeguardian.entities.seguro.MeioPagEntity;
import com.checkpoint.bikeguardian.repositories.seguro.MeioPagRepository;
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
@RequestMapping("/meiopag")
public class MeioPagController {
    @Autowired
    private MeioPagRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMeioPag dados, UriComponentsBuilder uriBuilder){
        var meioPag = new MeioPagEntity(dados);
        repository.save(meioPag);
        var uri = uriBuilder.path("/meiopag/{id}").buildAndExpand(meioPag.getIdMeioPag()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMeioPag(meioPag));
    }
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoMeioPag>> listar(){
        var meioPag = repository.findAll().stream().map(DadosDetalhamentoMeioPag :: new).collect(Collectors.toList());
        return ResponseEntity.ok(meioPag);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var meioPag = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMeioPag(meioPag));
    }
}
