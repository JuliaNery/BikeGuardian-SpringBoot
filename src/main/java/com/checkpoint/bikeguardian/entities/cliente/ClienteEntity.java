package com.checkpoint.bikeguardian.entities.cliente;

import com.checkpoint.bikeguardian.controller.cliente.DadosCadastroCliente;
import com.checkpoint.bikeguardian.entities.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "tbcliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteEntity {
    @Id
    private Long cpfCliente;
    private String nomeCliente;
    private String telCliente;
    private String emailCliente;
    @Embedded
    private Endereco endereco;
    private String senhaCliente;

    public ClienteEntity(DadosCadastroCliente dados) {
        this.setCpfCliente(dados.cpfCliente());
        this.setNomeCliente(dados.nomeCliente());
        this.setTelCliente(dados.telefoneCliente());
        this.setEmailCliente(dados.emailCliente());
        this.setEndereco(new Endereco(dados.enderecoCliente()));
        this.setSenhaCliente(dados.senhaCliente());
    }
}
