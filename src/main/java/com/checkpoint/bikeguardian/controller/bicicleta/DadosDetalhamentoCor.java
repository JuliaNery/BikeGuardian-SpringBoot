package com.checkpoint.bikeguardian.controller.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;

public record DadosDetalhamentoCor(Long id, String nome) {
    public DadosDetalhamentoCor(CorEntity cor){
        this(cor.getId(), cor.getNome());
    }
}
