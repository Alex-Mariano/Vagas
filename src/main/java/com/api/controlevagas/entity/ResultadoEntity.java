package com.api.controlevagas.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "RESULTADO")
public class ResultadoEntity {

    @Id
    @Column(name = "NUMEROAPARTAMENTO", nullable = false, unique = true)
    private Integer numeroApartamento;

    @Column(name = "NROVAGA1", length = 5, nullable = false)
    private String nroVaga1;

    @Column(name = "ANDARVAGA1", length = 5, nullable = false)
    private String andarVaga1;

    @Column(name = "NROVAGA2", length = 2)
    private String nroVaga2;

    @Column(name = "ANDARVAGA2", length = 4)
    private String andarVaga2;

}
