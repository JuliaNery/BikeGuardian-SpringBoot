package com.checkpoint.bikeguardian.entities.seguro;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbcobadc_seguro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CobAdcSeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcobadc_seguro")
    private Long idCobAdcSeguro;

    @Column(name = "valorcobadc")
    private Double valorCobAdcSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbcobadc_idcobadc")
    private CobAdcEntity cobAdc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbseguro_idseguro")
    private SeguroEntity seguro;


}
