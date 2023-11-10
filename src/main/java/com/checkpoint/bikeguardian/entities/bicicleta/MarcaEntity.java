package com.checkpoint.bikeguardian.entities.bicicleta;

import com.checkpoint.bikeguardian.controller.bicicleta.DadosCadastroMarca;
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

    private String nomeMarca;

    public MarcaEntity(DadosCadastroMarca dados) {
        this.setNomeMarca(dados.nomeMarca());
    }
}
