package com.checkpoint.bikeguardian.entities.bicicleta;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbmodelo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModeloEntity {
    @Id
    @Column(name = "idmodelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomemodelo")
    private String nome;
}
