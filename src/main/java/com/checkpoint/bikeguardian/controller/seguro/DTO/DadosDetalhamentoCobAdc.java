package com.checkpoint.bikeguardian.controller.seguro.DTO;

import com.checkpoint.bikeguardian.controller.seguro.Enum.CoberturaAdc;
import com.checkpoint.bikeguardian.entities.seguro.CobAdcEntity;

public record DadosDetalhamentoCobAdc(Long idCobAdc, CoberturaAdc coberturaAdc) {
    public DadosDetalhamentoCobAdc(CobAdcEntity cobAdc) {
        this(cobAdc.getIdCobAdc(), cobAdc.getCoberturaAdc());
    }
}
