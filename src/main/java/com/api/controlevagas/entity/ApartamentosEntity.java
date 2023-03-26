package com.api.controlevagas.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "APARTAMENTOS")
public class ApartamentosEntity {

    @Id
    @Column(name = "NUMEROAPARTAMENTO", nullable = false, unique = true)
    private Integer numeroApartamento;

    @Column(name = "ANDARVAGA1", length = 4)
    private String andarVaga1;

    @Column(name = "VAGA1", length = 7)
    private String vaga1;

    @Column(name = "ANDARVAGA2", length = 4)
    private String andarVaga2;

    @Column(name = "VAGA2", length = 7)
    private String vaga2;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "QUANTIDADEVAGAS")
    private Integer quantidadeVagas;

}
