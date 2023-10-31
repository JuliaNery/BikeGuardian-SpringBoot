package com.checkpoint.bikeguardian.entities.bicicleta;

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
    private Integer id;

    @Column(name = "nomemarca")
    private String nome;
}
