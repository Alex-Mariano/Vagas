package com.api.controlevagas.repository;

import com.api.controlevagas.entity.ResultadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<ResultadoEntity, Integer> {

}
