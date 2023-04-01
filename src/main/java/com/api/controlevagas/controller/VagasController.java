package com.api.controlevagas.controller;

import com.api.controlevagas.dto.VagasDto;
import com.api.controlevagas.entity.VagasEntity;
import com.api.controlevagas.repository.VagasRepository;
import com.api.controlevagas.service.VagasService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vagas", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class VagasController {

    @Autowired
    VagasService vagasService;
    @Autowired
    private VagasRepository vagasRepository;

    @ApiOperation(value = "Grava registro tabela Vagas")
    @PostMapping
    public ResponseEntity<Object> salvaVaga(@RequestBody VagasDto vagasDto) {
        var vagasEntity = new VagasEntity();
        BeanUtils.copyProperties(vagasDto, vagasEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(vagasService.save(vagasEntity));
    }

    @ApiOperation(value = "Recupera Vagas")
    @GetMapping(value = "/vagas")
    public ResponseEntity<List<VagasEntity>> buscaVagas() {
        var vagasEntity = vagasRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(vagasEntity);
    }

}
