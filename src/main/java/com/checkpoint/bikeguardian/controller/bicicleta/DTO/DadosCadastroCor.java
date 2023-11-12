package com.checkpoint.bikeguardian.controller.bicicleta.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCor(
        @NotBlank
        String nome) {
}
