package com.checkpoint.bikeguardian.controller.cliente;

import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import com.checkpoint.bikeguardian.entities.endereco.DadosEndereco;
import com.checkpoint.bikeguardian.entities.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoCliente( Long cpf, String nome, String telefone, String email, Endereco endereco, String senha) {
    public DadosDetalhamentoCliente(ClienteEntity cliente) {
        this(cliente.getCpfCliente(), cliente.getNomeCliente(), cliente.getTelCliente(), cliente.getEmailCliente(), cliente.getEndereco(), cliente.getSenhaCliente());
    }
}
