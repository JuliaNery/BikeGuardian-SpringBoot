package com.checkpoint.bikeguardian.entities.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DadosCadastroMarca;
import com.checkpoint.bikeguardian.controller.bicicleta.DadosCadastroModelo;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "ModeloEntity")
@Table(name = "tbmodelo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModeloEntity {
    @Id
    @Column(name = "idmodelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomemodelo")
    private String nome;

    public ModeloEntity(DadosCadastroModelo dados) {
        this.setNome(dados.nome());
    }
}
