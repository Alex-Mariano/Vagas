package com.api.controlevagas.repository;

import com.api.controlevagas.entity.Resultado2Entity;
import com.api.controlevagas.entity.VagasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Resultado2Repository extends JpaRepository<Resultado2Entity, Integer> {

}
