package com.checkpoint.bikeguardian.entities.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroBicicleta;
import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbbicicleta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BicicletaEntity {
    @Id
    @Column(name = "numserie")
    private String numSerie;
    @Column(name = "valornf")
    private Double valorNF;
    @Column(name = "qtdwatts")
    private Integer qtdWatts;
    @Column(name = "fotolateral")
    private String fotoLateral;
    @Column(name = "fotofrontal")
    private String fotoFrontal;
    @Column(name = "fototraseira")
    private String fotoTraseira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbcliente_cpfcliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbmarca_idmarca")
    private MarcaEntity marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbmodelo_idmodelo")
    private ModeloEntity modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbcor_idcor")
    private CorEntity cor;

}
