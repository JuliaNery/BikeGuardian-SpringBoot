package com.checkpoint.bikeguardian.entities.bicicleta;

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
    private Long numSerie;
    private Double valorNF;
    private String fotoLateral;
    private String fotoFrontal;
    private String fotoTraseira;
    private String fotoNumSerie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbCliente_cpfCliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbMarca_idMarca")
    private MarcaEntity marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbCor_idCor")
    private CorEntity cor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbModelo_idModelo")
    private ModeloEntity modelo;



}
