package com.checkpoint.bikeguardian.controller.bicicleta.DTO;

import com.checkpoint.bikeguardian.entities.bicicleta.ModeloEntity;
import com.checkpoint.bikeguardian.repositories.bicicleta.ModeloRepository;

public record DadosDetalhamentoModelo(Long id, String nome) {

    public DadosDetalhamentoModelo(ModeloEntity modelo) {
        this(modelo.getId(), modelo.getNome());
    }
}
