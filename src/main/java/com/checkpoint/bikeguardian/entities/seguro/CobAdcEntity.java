package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroCobAdc;
import com.checkpoint.bikeguardian.enums.CoberturaAdc;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbcobadc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CobAdcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcobadc")
    private Long idCobAdc;

    @Column(name = "coberturaadc")
    @Enumerated(EnumType.STRING)
    private CoberturaAdc coberturaAdc;

    public CobAdcEntity(DadosCadastroCobAdc dados) {
        this.setCoberturaAdc(dados.coberturaAdc());
    }
}
