package com.checkpoint.bikeguardian.entities.seguro.validacoes;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroCobAdcSeguro;
import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosDetalhamentoCobAdcSeguro;
import com.checkpoint.bikeguardian.entities.seguro.CobAdcSeguroEntity;
import com.checkpoint.bikeguardian.repositories.seguro.CobAdcRepository;
import com.checkpoint.bikeguardian.repositories.seguro.CobAdcSeguroRepository;
import com.checkpoint.bikeguardian.repositories.seguro.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoCobAdcSeguro {
    @Autowired
    private CobAdcSeguroRepository cobAdcSeguroRepository;

    @Autowired
    private CobAdcRepository cobAdcRepository;

    @Autowired
    private SeguroRepository seguroRepository;

    public DadosDetalhamentoCobAdcSeguro cadastrar(DadosCadastroCobAdcSeguro dados){
        var seguro = seguroRepository.getReferenceById(dados.idSeguro());
        var cobAdc = cobAdcRepository.getReferenceById(dados.idCobAdc());

        var cobAdcSeguro = new CobAdcSeguroEntity(dados.idSeguro(), dados.valorCobAdc(), cobAdc, seguro);
        cobAdcSeguroRepository.save(cobAdcSeguro);
        return new DadosDetalhamentoCobAdcSeguro(cobAdcSeguro);




    }
}
