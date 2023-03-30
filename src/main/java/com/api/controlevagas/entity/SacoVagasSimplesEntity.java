package com.api.controlevagas.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SACO_VAGAS_SIMPLES")
public class SacoVagasSimplesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_VAGAS_SIMPLES", nullable = false, unique = true)
    private Integer idVagasSimples;

    @Column(name = "NROVAGA", length = 5, nullable = false)
    private String nroVaga;

    @Column(name = "ANDARVAGA", length = 4, nullable = false)
    private String andarVaga;

}
