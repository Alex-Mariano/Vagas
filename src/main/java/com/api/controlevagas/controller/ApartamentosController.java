package com.api.controlevagas.controller;

import com.api.controlevagas.dto.ApartamentosDto;
import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.repository.ApartamentosRepository;
import com.api.controlevagas.service.ApartamentosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class ApartamentosController {

    @Autowired
    ApartamentosService apartamentosService;
    @Autowired
    ApartamentosRepository apartamentosRepository;

    @PostMapping
    public ResponseEntity<Object> saveApartamento(@RequestBody ApartamentosDto apartamentosDto) {
        var apartamentosEntity = new ApartamentosEntity();
        BeanUtils.copyProperties(apartamentosDto, apartamentosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(apartamentosService.save(apartamentosEntity));
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<ApartamentosEntity>> lista() {
        return ResponseEntity.status(HttpStatus.OK).body((List<ApartamentosEntity>) apartamentosService.findAll());
    }
}
