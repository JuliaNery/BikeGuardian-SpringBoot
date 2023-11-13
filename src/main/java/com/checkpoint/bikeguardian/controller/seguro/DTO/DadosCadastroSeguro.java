package com.checkpoint.bikeguardian.controller.seguro.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroSeguro(
        @NotNull
        Long idMeioPag,
        @NotNull
        Long idTipoSeguro,
        @NotNull
        String idBicicleta
        ) {
}
