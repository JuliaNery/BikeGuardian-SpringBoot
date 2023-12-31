package com.checkpoint.bikeguardian.controller.bicicleta.DTO;

import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;

public record DadosDetalhamentoMarca(Long idMarca, String nomeMarca) {
    public DadosDetalhamentoMarca(MarcaEntity marca){
        this(marca.getId(),marca.getNomeMarca());
    }
}
