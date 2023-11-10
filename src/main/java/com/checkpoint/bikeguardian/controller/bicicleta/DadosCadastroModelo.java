package com.checkpoint.bikeguardian.controller.bicicleta;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroModelo(
        @NotBlank
        String nome) {
}
