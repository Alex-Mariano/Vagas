package com.api.controlevagas.controller;

import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.entity.SacoApartamentosEntity;
import com.api.controlevagas.repository.ApartamentosRepository;
import com.api.controlevagas.repository.SacoApartamentosRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/sorteio", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class SacoApartamentosController {

    @Autowired
    ApartamentosRepository apartamentosRepository;

    @Autowired
    SacoApartamentosRepository sacoApartamentosRepository;

    @ApiOperation(value = "Coloca Apartamentos no Saco")
    @PostMapping
    public ResponseEntity<Object> salvaSacoApartamento() {

        List<ApartamentosEntity> apartamentosEntityList = apartamentosRepository.findAll();

        var sacoApartamentosEntity = new SacoApartamentosEntity();

        Collections.shuffle(apartamentosEntityList);

        apartamentosEntityList.forEach(det -> {
                    sacoApartamentosEntity.setNumeroApartamento(det.getNumeroApartamento());
                    sacoApartamentosEntity.setIdVaga(det.getIdVagaDeposito());
                    sacoApartamentosEntity.setQuantidadeVagas(det.getQuantidadeVagas());

                    sacoApartamentosRepository.save(sacoApartamentosEntity);
                }
        );

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}
