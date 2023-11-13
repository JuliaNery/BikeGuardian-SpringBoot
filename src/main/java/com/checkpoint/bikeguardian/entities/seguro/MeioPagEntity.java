package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DTO.DadosCadastroMeioPag;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbmeiopag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeioPagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmeiopag")
    private Long idMeioPag;
    @Column(name = "nomemeiopag")
    private String nomePag;

    public MeioPagEntity(DadosCadastroMeioPag dados) {
        this.setNomePag(dados.nomeMeioPag());
    }
}
