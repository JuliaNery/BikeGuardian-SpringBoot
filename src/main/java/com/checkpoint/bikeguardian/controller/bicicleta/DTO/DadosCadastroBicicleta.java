package com.checkpoint.bikeguardian.controller.bicicleta.DTO;

import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.ModeloEntity;
import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroBicicleta(
        @NotBlank
        String numSerie,
        @NotNull
        Double valorNF,
        Integer qtdWatts,
        String fotoLateral,
        String fotoFrontal,
        String fotoTraseira,
        @NotNull
        Long idCliente,
        @NotNull
        Long idMarca,
        @NotNull
        Long idCor,
        @NotNull
        Long idModelo
) {
}
