package com.checkpoint.bikeguardian.controller.cliente.DTO;

import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import com.checkpoint.bikeguardian.entities.endereco.DadosEndereco;
import com.checkpoint.bikeguardian.entities.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public record DadosCadastroCliente(
        @NotNull(message = "O CPF do cliente é obrigatório")
        Long cpfCliente,
        @NotBlank
        String nomeCliente,
        @NotBlank
        String telCliente,
        @Email
        String emailCliente,
        @NotNull
        @Valid
        DadosEndereco enderecoCliente,
        @NotBlank
        String senhaCliente
        ) {

}
