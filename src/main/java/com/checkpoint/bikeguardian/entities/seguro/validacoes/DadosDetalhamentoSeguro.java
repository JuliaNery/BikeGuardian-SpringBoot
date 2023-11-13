package com.checkpoint.bikeguardian.entities.seguro.validacoes;

import com.checkpoint.bikeguardian.entities.seguro.SeguroEntity;
import com.checkpoint.bikeguardian.enums.StatusSeguro;

public record DadosDetalhamentoSeguro(
        Long idSeguro,
        Double valorSeguro,
        StatusSeguro statusSeguro,
        Long idMeioPag,
        Long idTipoSeguro,
        String idBicicleta
        ) {
    public DadosDetalhamentoSeguro(SeguroEntity seguro) {
        this(seguro.getIdSeguro(), seguro.getValorSeguro(), seguro.getStatusSeguro(),seguro.getMeioPag().getIdMeioPag(), seguro.getTipoSeguro().getIdTipoSeguro(),seguro.getBicicleta().getNumSerie());
    }
}
