package com.checkpoint.bikeguardian.entities.cliente;

import com.checkpoint.bikeguardian.controller.cliente.DTO.DadosCadastroCliente;
import com.checkpoint.bikeguardian.entities.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "tbCliente")
@Table(name = "tbcliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteEntity {
    @Id
    @Column(name = "cpfcliente")
    private Long cpfCliente;
    @Column(name = "nomecliente")
    private String nomeCliente;
    @Column(name = "telcliente")
    private String telCliente;
    @Column(name = "emailcliente")
    private String emailCliente;
    @Embedded
    private Endereco endereco;
    @Column(name = "senhacliente")
    private String senhaCliente;

    public ClienteEntity(DadosCadastroCliente dados) {
        this.setCpfCliente(dados.cpfCliente());
        this.setNomeCliente(dados.nomeCliente());
        this.setTelCliente(dados.telCliente());
        this.setEmailCliente(dados.emailCliente());
        this.setEndereco(new Endereco(dados.enderecoCliente()));
        this.setSenhaCliente(dados.senhaCliente());
    }
}
