package com.api.controlevagas.controller;

import com.api.controlevagas.dto.ApartamentosDto;
import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.service.ApartamentosService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vagas")
public class ApartamentosController {

    @Autowired
    ApartamentosService apartamentosService;

    @PostMapping
    public ResponseEntity<Object> saveApartamento(@RequestBody ApartamentosDto apartamentosDto) {
        var apartamentosEntity = new ApartamentosEntity();
        BeanUtils.copyProperties(apartamentosDto, apartamentosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(apartamentosService.save(apartamentosEntity));
    }
}
