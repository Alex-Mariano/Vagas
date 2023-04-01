package com.api.controlevagas.service;

import com.api.controlevagas.entity.ApartamentosEntity;
import com.api.controlevagas.entity.ResultadoEntity;
import com.api.controlevagas.entity.VagasEntity;
import com.api.controlevagas.repository.ApartamentosRepository;
import com.api.controlevagas.repository.ResultadoRepository;
import com.api.controlevagas.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SorteioService {

    @Autowired
    ApartamentosRepository apartamentosRepository;

    @Autowired
    ResultadoRepository resultadoRepository;

    @Autowired
    VagasRepository vagasRepository;

    @Transactional
    public void execute() {

//        resultadoRepository.deleteAll();
//
//        carregaPreResultado();

        List<VagasEntity> vagas = vagasRepository.findAll();

        List<ResultadoEntity> resultadoEntities = resultadoRepository.findAll();

        atualizaVagasEnfrenteAoDeposito(vagas, resultadoEntities);

        resultadoRepository.saveAll(resultadoEntities);
    }

    private static void atualizaVagasEnfrenteAoDeposito(List<VagasEntity> vagas, List<ResultadoEntity> resultadoEntities) {

        resultadoEntities.forEach(
                det -> {

                    Integer idVaga = det.getIdVagaDeposito();

                    if (idVaga != null) {

                        Optional<VagasEntity> dadosVaga = vagas.stream()
                                .filter(f -> Objects.equals(f.getIdVaga(), idVaga))
                                .findFirst();

                        Integer quantidadeVagas = det.getQuantidadeVagas();
                        String nroVaga = dadosVaga.get().getNroVaga();
                        String andarVaga = dadosVaga.get().getAndarVaga();

                        det.setNroVaga1(nroVaga);
                        det.setAndarVaga1(andarVaga);

                        if (quantidadeVagas == 1) {
                            det.setNroVaga2("");
                            det.setAndarVaga2("");
                        }
                    }
                }
        );
    }

    private void carregaPreResultado() {

        List<ApartamentosEntity> apartamentosEntityList = apartamentosRepository.findAll();

        var resultado2Entity = new ResultadoEntity();

        Collections.shuffle(apartamentosEntityList);

        apartamentosEntityList.forEach(det -> {
                    resultado2Entity.setIdResultado(1);
                    resultado2Entity.setNumeroApartamento(det.getNumeroApartamento());
                    resultado2Entity.setQuantidadeVagas(det.getQuantidadeVagas());
                    resultado2Entity.setIdVagaDeposito(det.getIdVagaDeposito());

                    resultadoRepository.save(resultado2Entity);
                }
        );
    }

}
