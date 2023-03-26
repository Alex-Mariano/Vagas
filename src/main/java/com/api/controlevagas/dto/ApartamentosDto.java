package com.api.controlevagas.dto;

import lombok.Data;

@Data
public class ApartamentosDto {

    private Integer numeroApartamento;

    private String andarVaga1;

    private String vaga1;

    private String andarVaga2;

    private String vaga2;

    private boolean status;

    private Integer quantidadeVagas;
}
