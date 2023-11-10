package com.checkpoint.bikeguardian.repositories.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {

}
