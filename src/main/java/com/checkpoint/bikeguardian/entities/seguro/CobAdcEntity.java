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
public class CobAdcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCobAdc;
    private String coberturaAdc;
}
