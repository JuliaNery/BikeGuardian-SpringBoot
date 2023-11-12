package com.checkpoint.bikeguardian.controller.bicicleta.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMarca(
        @NotBlank
        String nomeMarca
) {
}
