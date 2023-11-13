package com.checkpoint.bikeguardian.controller.seguro.DTO;

import com.checkpoint.bikeguardian.controller.seguro.Enum.TipoSeguro;
import com.checkpoint.bikeguardian.entities.seguro.TipoSeguroEntity;

public record DadosDetalhamentoTipoSeguro(Long idTipoSeguro, TipoSeguro tipoSeguro, Double valorTipoSeguro) {
    public DadosDetalhamentoTipoSeguro(TipoSeguroEntity tipoSeguro) {
        this(tipoSeguro.getIdTipoSeguro(), tipoSeguro.getTipoSeguro(), tipoSeguro.getValorTipoSeguro());
    }
}
