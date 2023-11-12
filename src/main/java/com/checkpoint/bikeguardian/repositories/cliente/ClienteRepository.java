package com.checkpoint.bikeguardian.repositories.cliente;

import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;
import com.checkpoint.bikeguardian.entities.cliente.ClienteEntity;
import com.checkpoint.bikeguardian.entities.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

}
