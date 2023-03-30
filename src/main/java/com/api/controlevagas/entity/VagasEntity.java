package com.api.controlevagas.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "VAGAS")
public class VagasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_VAGA", nullable = false, unique = true)
    private Integer idVaga;

    @Column(name = "NROVAGA", length = 5, nullable = false)
    private String nroVaga;

    @Column(name = "TIPOVAGA", length = 1, nullable = false)
    private String tipoVaga;

    @Column(name = "ANDARVAGA", length = 4, nullable = false)
    private String andarVaga;

    @Column(name = "ENFRETEDEPOSITO", nullable = false)
    private boolean enfreteDepositos;

}
