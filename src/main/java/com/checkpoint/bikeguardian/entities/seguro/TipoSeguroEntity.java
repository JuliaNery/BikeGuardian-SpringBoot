package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroTipoSeguro;
import com.checkpoint.bikeguardian.controller.seguro.Enum.TipoSeguro;
import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;

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
    @Column(name = "idtiposeguro")
    private Long idTipoSeguro;
    @Column(name = "tiposeguro")
    @Enumerated(EnumType.STRING)
    private TipoSeguro tipoSeguro;
    @Column(name = "valortiposeguro")
    private Double valorTipoSeguro;

    public TipoSeguroEntity(DadosCadastroTipoSeguro dados) {
        this.setTipoSeguro(dados.tipoSeguro());
        if (getTipoSeguro() == TipoSeguro.PEDAL_ESSENCIAL){
            this.setValorTipoSeguro(120.00);
        } else if (getTipoSeguro() == TipoSeguro.PEDAL_LEVE) {
            this.setValorTipoSeguro(150.00);
        }else {
            this.setValorTipoSeguro(200.00);
        }
    }
}
