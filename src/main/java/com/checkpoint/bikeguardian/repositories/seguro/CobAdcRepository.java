package com.checkpoint.bikeguardian.repositories.seguro;

import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;
import com.checkpoint.bikeguardian.entities.seguro.CobAdcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobAdcRepository extends JpaRepository<CobAdcEntity, Long> {
}
