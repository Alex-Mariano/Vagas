package com.api.controlevagas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
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
