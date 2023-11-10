package com.checkpoint.bikeguardian.repositories.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicicletaRepository extends JpaRepository<BicicletaEntity, Long> {
}
