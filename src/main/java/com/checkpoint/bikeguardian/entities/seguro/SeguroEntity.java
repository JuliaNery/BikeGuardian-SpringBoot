package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.enums.StatusSeguro;
import jakarta.persistence.*;
import lombok.*;

import javax.swing.text.SimpleAttributeSet;

@Data
@Entity
@Table(name = "tbmodelo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguro;

    private Double valorSeguro;
    @Enumerated(EnumType.STRING)
    private StatusSeguro statusSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbMeioPag_idMeioPag")
    private MeioPagEntity meioPag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbTipoSeguro_idTipoSeguro")
    private TipoSeguroEntity tipoSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbBicicleta_numSerie")
    private BicicletaEntity bicicleta;
}
