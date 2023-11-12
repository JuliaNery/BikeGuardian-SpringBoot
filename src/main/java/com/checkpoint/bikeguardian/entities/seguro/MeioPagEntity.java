package com.checkpoint.bikeguardian.entities.seguro;

import com.checkpoint.bikeguardian.controller.seguro.DadosCadastroMeioPag;
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
    private Long idMeioPag;
    private String nomePag;

    public MeioPagEntity(DadosCadastroMeioPag dados) {
        this.setNomePag(dados.nomeMeioPag());
    }
}
