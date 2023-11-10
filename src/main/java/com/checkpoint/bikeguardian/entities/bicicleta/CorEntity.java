package com.checkpoint.bikeguardian.entities.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DadosCadastroCor;
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
    @Column(name = "idmodelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomemodelo")
    private String nome;

    public CorEntity(DadosCadastroCor dados) {

    }
}
