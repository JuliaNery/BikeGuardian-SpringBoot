package com.checkpoint.bikeguardian.controller.bicicleta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMarca(
        @NotBlank
        String nomeMarca
) {
}
