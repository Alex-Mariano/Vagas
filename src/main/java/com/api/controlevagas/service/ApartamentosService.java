package com.api.controlevagas.service;

import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.repository.ApartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApartamentosService {

    @Autowired
    ApartamentosRepository apartamentosRepository;

    @Transactional
    public ApartamentosEntity save(ApartamentosEntity apartarmentosEntity) {
        return apartamentosRepository.save(apartarmentosEntity);
    }

    public Object findAll() {
        return apartamentosRepository.findAll();
    }
}
