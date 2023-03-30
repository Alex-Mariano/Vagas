package com.api.controlevagas.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SACO_APARTAMENTOS")
public class SacoApartamentosEntity {

    @Id
    @Column(name = "NUMEROAPARTAMENTO", nullable = false, unique = true)
    private Integer numeroApartamento;

    @Column(name = "QUANTIDADEVAGAS", nullable = false)
    private Integer quantidadeVagas;

    @Column(name = "ID_VAGA", nullable = false)
    private Integer idVaga;

}
