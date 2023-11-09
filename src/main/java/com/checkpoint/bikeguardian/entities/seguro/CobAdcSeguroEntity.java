package com.checkpoint.bikeguardian.entities.seguro;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbmodelo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CobAdcSeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCobAdc_Seguro")
    private Long idCobAdcSeguro;

    private Double valorCobAdcSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbCobAdc_idCobAdc")
    private CobAdcEntity cobAdc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbSeguro_idSeguro")
    private SeguroEntity seguro;

}
