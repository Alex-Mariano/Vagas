package com.api.controlevagas.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SACO_VAGAS_DUPLAS")
public class SacoVagasDuplasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_VAGAS_DUPLAS", nullable = false, unique = true)
    private Integer idVagasDuplas;

    @Column(name = "NROVAGA", length = 5, nullable = false)
    private String nroVaga;

    @Column(name = "ANDARVAGA", length = 4, nullable = false)
    private String andarVaga;

}
