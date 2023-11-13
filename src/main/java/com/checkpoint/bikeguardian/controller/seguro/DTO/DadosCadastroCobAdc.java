package com.checkpoint.bikeguardian.controller.seguro.DTO;

import com.checkpoint.bikeguardian.enums.CoberturaAdc;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCobAdc(
        @NotNull
        CoberturaAdc coberturaAdc) {
}
