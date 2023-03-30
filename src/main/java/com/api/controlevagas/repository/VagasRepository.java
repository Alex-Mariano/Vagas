package com.api.controlevagas.repository;

import com.api.controlevagas.entity.VagasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagasRepository extends JpaRepository<VagasEntity, Integer> {

}
