package com.checkpoint.bikeguardian.repositories.seguro;

import com.checkpoint.bikeguardian.entities.seguro.CobAdcEntity;
import com.checkpoint.bikeguardian.entities.seguro.TipoSeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSeguroRepository extends JpaRepository<TipoSeguroEntity, Long> {
}
