package com.checkpoint.bikeguardian.entities.seguro.validacoes;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroSeguro;
import com.checkpoint.bikeguardian.controller.seguro.Enum.TipoSeguro;
import com.checkpoint.bikeguardian.entities.ValidacaoException;
import com.checkpoint.bikeguardian.entities.seguro.SeguroEntity;
import com.checkpoint.bikeguardian.enums.StatusSeguro;
import com.checkpoint.bikeguardian.repositories.bicicleta.BicicletaRepository;
import com.checkpoint.bikeguardian.repositories.seguro.MeioPagRepository;
import com.checkpoint.bikeguardian.repositories.seguro.SeguroRepository;
import com.checkpoint.bikeguardian.repositories.seguro.TipoSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoSeguro {
    @Autowired
    SeguroRepository seguroRepository;

    @Autowired
    MeioPagRepository meioPagRepository;

    @Autowired
    TipoSeguroRepository tipoSeguroRepository;

    @Autowired
    BicicletaRepository bicicletaRepository;

    public DadosDetalhamentoSeguro cadastrar(DadosCadastroSeguro dados){
        var meioPag = meioPagRepository.getReferenceById(dados.idMeioPag());
        var tipoSeg = tipoSeguroRepository.getReferenceById(dados.idTipoSeguro());
        var bike = bicicletaRepository.getReferenceById(dados.idBicicleta());
        if(bike.getValorNF() > 10000.00){
            throw new ValidacaoException("Valor da bicicleta acima do limite");
        }
        var valSeguro = calculaSeguro(meioPag.getNomePag(), tipoSeg.getValorTipoSeguro(), bike.getValorNF());

        var seguro = new SeguroEntity(dados.idTipoSeguro(), valSeguro, StatusSeguro.APROVADO, meioPag,tipoSeg,bike);
        seguroRepository.save(seguro);
        return new DadosDetalhamentoSeguro(seguro);
    }

    private Double calculaSeguro(String nomePag, Double valorTipoSeguro, Double valorNF) {
        var valorSeguro = valorTipoSeguro;
        valorSeguro += valorNF * 0.1;
        if(nomePag.equals("pix")){
            valorSeguro -= valorSeguro * 0.15;
        }
        return valorSeguro;
    }
}
