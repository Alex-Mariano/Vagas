package com.api.controlevagas.service;

import com.api.controlevagas.entity.VagasEntity;
import com.api.controlevagas.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VagasService {

    @Autowired
    VagasRepository vagasRepository;

    @Transactional
    public VagasEntity save(VagasEntity vagasEntity) {

        return vagasRepository.save(vagasEntity);

    }

}
