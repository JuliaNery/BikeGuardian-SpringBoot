package com.checkpoint.bikeguardian.repositories.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.CorEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends JpaRepository<CorEntity, Long> {
}
