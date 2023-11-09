package com.checkpoint.bikeguardian.entities.seguro;

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

}
