package com.api.controlevagas.controller;

import com.api.controlevagas.dto.ApartamentosDto;
import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.repository.ApartamentosRepository;
import com.api.controlevagas.service.ApartamentosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apartamentos", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class ApartamentosController {

    @Autowired
    ApartamentosService apartamentosService;

    @Autowired
    ApartamentosRepository apartamentosRepository;

    @ApiOperation(value = "Grava registro tabela Apartamentos")
    @PostMapping
    public ResponseEntity<Object> saveApartamento(@RequestBody ApartamentosDto apartamentosDto) {
        var apartamentosEntity = new ApartamentosEntity();
        BeanUtils.copyProperties(apartamentosDto, apartamentosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(apartamentosService.save(apartamentosEntity));
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<Object> procura(@PathVariable(value = "id") Integer id) {
        Optional<ApartamentosEntity> apartamentosEntity = apartamentosService.findById(id);
        if (!apartamentosEntity.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartamento não cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(apartamentosEntity.get());
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ApartamentosEntity>> listaw() {
        var apartamentosEntity = apartamentosRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apartamentosEntity);
    }
}
