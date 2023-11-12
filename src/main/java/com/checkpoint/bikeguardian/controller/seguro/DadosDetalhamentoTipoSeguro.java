package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.entities.seguro.TipoSeguroEntity;

public record DadosDetalhamentoTipoSeguro(Long idTipoSeguro, String tipoSeguro, Double valorTipoSeguro) {
    public DadosDetalhamentoTipoSeguro(TipoSeguroEntity tipoSeguro) {
        this(tipoSeguro.getIdTipoSeguro(), tipoSeguro.getTipoSeguro(), tipoSeguro.getValorTipoSeguro());
    }
}