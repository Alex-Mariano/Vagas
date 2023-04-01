package com.api.controlevagas.service;

import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.entity.Resultado2Entity;
import com.api.controlevagas.repository.ApartamentosRepository;
import com.api.controlevagas.repository.Resultado2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class SorteioService {

    @Autowired
    ApartamentosRepository apartamentosRepository;

    @Autowired
    Resultado2Repository resultado2Repository;

    @Transactional
    public void execute() {

        carregaPreResultado();

        
    }

    private void carregaPreResultado() {

        List<ApartamentosEntity> apartamentosEntityList = apartamentosRepository.findAll();

        var resultado2Entity = new Resultado2Entity();

        Collections.shuffle(apartamentosEntityList);

        apartamentosEntityList.forEach(det -> {
                    resultado2Entity.setIdResultado(1);
                    resultado2Entity.setNumeroApartamento(det.getNumeroApartamento());
                    resultado2Entity.setQuantidadeVagas(det.getQuantidadeVagas());
                    resultado2Entity.setIdVagaDeposito(det.getIdVagaDeposito());

                    resultado2Repository.save(resultado2Entity);
                }
        );
    }

}
