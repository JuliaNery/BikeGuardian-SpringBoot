package com.checkpoint.bikeguardian.entities.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroCor;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbcor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CorEntity {
    @Id
    @Column(name = "idcor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomecor")
    private String nome;

    public CorEntity(DadosCadastroCor dados) {
        this.setNome(dados.nome());
    }
}
