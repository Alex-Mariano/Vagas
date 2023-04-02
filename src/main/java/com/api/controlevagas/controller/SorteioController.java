package com.api.controlevagas.controller;

import com.api.controlevagas.service.SorteioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sorteio", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class SorteioController {

    @Autowired
    SorteioService sorteioVagas;

    @ApiOperation(value = "Sorteio")
    @PostMapping(value = "/apartamentos")
    public ResponseEntity<Object> sorteioApartamento() {

        sorteioVagas.sorteioApartamentos();

        return ResponseEntity.status(HttpStatus.OK).body("Sorteio Realizado");
    }
    @ApiOperation(value = "Sorteio")
    @PostMapping(value = "/vagas")
    public ResponseEntity<Object> sorteioVaga() {

        sorteioVagas.sorteioVagas();

        return ResponseEntity.status(HttpStatus.OK).body("Sorteio Realizado");
    }

}
