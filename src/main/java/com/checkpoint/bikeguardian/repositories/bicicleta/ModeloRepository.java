package com.checkpoint.bikeguardian.repositories.bicicleta;

import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import com.checkpoint.bikeguardian.entities.bicicleta.ModeloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<ModeloEntity, Long> {

}
