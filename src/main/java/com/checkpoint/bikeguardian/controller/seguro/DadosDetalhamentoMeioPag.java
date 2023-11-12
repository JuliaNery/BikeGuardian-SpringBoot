package com.checkpoint.bikeguardian.controller.seguro;

import com.checkpoint.bikeguardian.entities.seguro.MeioPagEntity;

public record DadosDetalhamentoMeioPag(Long idMeioPag, String nomePag) {
    public DadosDetalhamentoMeioPag(MeioPagEntity meioPag) {
        this(meioPag.getIdMeioPag(), meioPag.getNomePag());
    }
}
