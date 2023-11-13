package com.checkpoint.bikeguardian.controller.seguro.DTO;

import com.checkpoint.bikeguardian.controller.seguro.Enum.TipoSeguro;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTipoSeguro(
        @NotNull
        TipoSeguro tipoSeguro) {
}
