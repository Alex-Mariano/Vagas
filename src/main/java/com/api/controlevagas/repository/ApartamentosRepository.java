package com.api.controlevagas.repository;

import com.api.controlevagas.entity.ApartamentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentosRepository extends JpaRepository<ApartamentosEntity, Integer> {

}
