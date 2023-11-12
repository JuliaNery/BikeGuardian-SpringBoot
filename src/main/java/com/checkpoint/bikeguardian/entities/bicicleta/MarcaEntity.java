package com.checkpoint.bikeguardian.entities.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DTO.DadosCadastroMarca;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbmarca")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MarcaEntity {
    @Id
    @Column(name = "idmarca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomemarca")
    private String nomeMarca;

    public MarcaEntity(DadosCadastroMarca dados) {
        this.setNomeMarca(dados.nomeMarca());
    }
}
