package com.checkpoint.bikeguardian.controller.bicicleta.DTO;

import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;

public record DadosDetalhamentoBicicleta(
        String numSerie,
        Double valorNF,
        Integer qtdWatts,
        String fotoLateral,
        String fotoFrontal,
        String fotoTraseira,
        Long idCliente,
        Long idMarca,
        Long idModelo,
        Long idCor
        ) {
    public DadosDetalhamentoBicicleta(BicicletaEntity bicicleta) {
        this(bicicleta.getNumSerie(), bicicleta.getValorNF(), bicicleta.getQtdWatts(), bicicleta.getFotoLateral(), bicicleta.getFotoFrontal(), bicicleta.getFotoTraseira(), bicicleta.getCliente().getCpfCliente(), bicicleta.getMarca().getId(), bicicleta.getModelo().getId(), bicicleta.getCor().getId());
    }
}
