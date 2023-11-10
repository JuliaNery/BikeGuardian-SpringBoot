package com.checkpoint.bikeguardian.controller.bicicleta;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCor(
        @NotBlank
        String nome) {
}
