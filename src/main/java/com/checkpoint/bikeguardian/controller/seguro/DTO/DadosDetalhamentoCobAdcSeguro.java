package com.checkpoint.bikeguardian.controller.seguro.DTO;

import com.checkpoint.bikeguardian.entities.seguro.CobAdcSeguroEntity;

public record DadosDetalhamentoCobAdcSeguro(Long idCobAdcSeguro, Double valorCobAdcSeguro, Long idCobAdc, Long idSeguro) {
    public DadosDetalhamentoCobAdcSeguro(CobAdcSeguroEntity cobAdcSeguro) {
        this(cobAdcSeguro.getIdCobAdcSeguro(), cobAdcSeguro.getValorCobAdcSeguro(), cobAdcSeguro.getCobAdc().getIdCobAdc(), cobAdcSeguro.getSeguro().getIdSeguro());
    }
}
