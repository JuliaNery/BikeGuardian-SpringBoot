package com.checkpoint.bikeguardian.controller.seguro.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCobAdcSeguro(
        @NotNull
        Double valorCobAdc,
        @NotNull
        Long idCobAdc,
        @NotNull
        Long idSeguro
) {
}
