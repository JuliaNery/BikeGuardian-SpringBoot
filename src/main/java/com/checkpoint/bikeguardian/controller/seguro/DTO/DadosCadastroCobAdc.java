package com.checkpoint.bikeguardian.controller.seguro.DTO;

import com.checkpoint.bikeguardian.controller.seguro.Enum.CoberturaAdc;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCobAdc(
        @NotNull
        CoberturaAdc coberturaAdc) {
}
