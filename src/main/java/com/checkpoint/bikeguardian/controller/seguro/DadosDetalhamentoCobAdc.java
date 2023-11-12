package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.entities.seguro.CobAdcEntity;

public record DadosDetalhamentoCobAdc(Long idCobAdc, String coberturaAdc) {
    public DadosDetalhamentoCobAdc(CobAdcEntity cobAdc) {
        this(cobAdc.getIdCobAdc(), cobAdc.getCoberturaAdc());
    }
}
