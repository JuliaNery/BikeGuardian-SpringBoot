package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.enums.StatusSeguro;
import jakarta.persistence.*;
import lombok.*;

import javax.swing.text.SimpleAttributeSet;

@Data
@Entity
@Table(name = "tbseguro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseguro")
    private Long idSeguro;

    @Column(name = "valorseguro")
    private Double valorSeguro;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusseguro")
    private StatusSeguro statusSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbmeiopag_idmeiopag")
    private MeioPagEntity meioPag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbtiposeguro_idtiposeguro")
    private TipoSeguroEntity tipoSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbbicicleta_numserie")
    private BicicletaEntity bicicleta;
}
