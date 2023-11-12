package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroTipoSeguro;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbtiposeguro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoSeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSeguro;
    private String tipoSeguro;
    private Double valorTipoSeguro;

    public TipoSeguroEntity(DadosCadastroTipoSeguro dados) {
        this.setTipoSeguro(dados.tipoSeguro());
    }
}
