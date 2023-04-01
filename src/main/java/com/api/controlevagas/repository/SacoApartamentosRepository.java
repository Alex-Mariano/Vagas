package com.api.controlevagas.repository;

import com.api.controlevagas.entity.SacoApartamentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SacoApartamentosRepository extends JpaRepository<SacoApartamentosEntity, Integer> {

}
