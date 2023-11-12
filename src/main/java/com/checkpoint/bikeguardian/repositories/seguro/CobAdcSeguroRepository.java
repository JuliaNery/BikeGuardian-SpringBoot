package com.checkpoint.bikeguardian.repositories.seguro;

import com.checkpoint.bikeguardian.entities.bicicleta.BicicletaEntity;
import com.checkpoint.bikeguardian.entities.seguro.CobAdcSeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobAdcSeguroRepository extends JpaRepository<CobAdcSeguroEntity, Long> {
}
