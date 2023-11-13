package com.checkpoint.bikeguardian.entities.bicicleta.validacoes;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosDetalhamentoBicicleta;
import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroBicicleta;
import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.repositories.bicicleta.BicicletaRepository;
import com.checkpoint.bikeguardian.repositories.bicicleta.CorRepository;
import com.checkpoint.bikeguardian.repositories.bicicleta.MarcaRepository;
import com.checkpoint.bikeguardian.repositories.bicicleta.ModeloRepository;
import com.checkpoint.bikeguardian.repositories.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoBicicleta {
    @Autowired
    BicicletaRepository bicicletaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    ModeloRepository modeloRepository;

    @Autowired
    CorRepository corRepository;

    public DadosDetalhamentoBicicleta cadastrar(DadosCadastroBicicleta dados){

        var cliente = clienteRepository.getReferenceById(dados.idCliente());
        var marca = marcaRepository.getReferenceById(dados.idMarca());
        var modelo = modeloRepository.getReferenceById(dados.idModelo());
        var cor = corRepository.getReferenceById(dados.idCor());

        var bicicleta = new BicicletaEntity(dados.numSerie(),
                                            dados.valorNF(),
                                            dados.qtdWatts(),
                                            dados.fotoLateral(),
                                            dados.fotoFrontal(),
                                            dados.fotoTraseira(),
                                            cliente,
                                            marca,
                                            modelo,
                                            cor);
        bicicletaRepository.save(bicicleta);
        return new DadosDetalhamentoBicicleta(bicicleta);
    }

}
