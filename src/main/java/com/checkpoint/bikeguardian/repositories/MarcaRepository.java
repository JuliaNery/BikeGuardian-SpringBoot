package com.checkpoint.bikeguardian.repositories;

import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Integer> {
    List<MarcaEntity> findAll();
}
