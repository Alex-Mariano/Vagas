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

    public static final String SIMPLES = "S";
    public static final String DUPLA = "D";
    public static final boolean FALSO = false;
    @Autowired
    ApartamentosRepository apartamentosRepository;

    @Autowired
    ResultadoRepository resultadoRepository;

    @Autowired
    VagasRepository vagasRepository;

    @Transactional
    public void sorteioVagas() {

        List<VagasEntity> vagasSimples = embaralhaVagasSimples();

        List<VagasEntity> vagasDuplas = embaralhaVagasDuplas();

        List<ResultadoEntity> resultadoEntities = resultadoRepository.findAll();

        atualizaVagasSimplesEDuplas(vagasSimples, vagasDuplas, resultadoEntities);

        resultadoRepository.saveAll(resultadoEntities);
    }

    @Transactional
    public void sorteioApartamentos() {

        carregaPreResultado();

        List<VagasEntity> vagas = vagasRepository.findAll();

        List<ResultadoEntity> resultadoEntities = resultadoRepository.findAll();

        atualizaVagasEnfrenteAoDeposito(vagas, resultadoEntities);

        resultadoRepository.saveAll(resultadoEntities);
    }

    private static void atualizaVagasSimplesEDuplas(List<VagasEntity> vagasSimples, List<VagasEntity> vagasDuplas, List<ResultadoEntity> resultadoEntities) {

        resultadoEntities.forEach(det -> {

            Integer quantidadeVagas = det.getQuantidadeVagas();
            String nroVaga1 = det.getNroVaga1();

            if (quantidadeVagas == 1) {

                if (nroVaga1 == null) {

                    det.setNroVaga1(vagasSimples.get(0).getNroVaga());
                    det.setAndarVaga1(vagasSimples.get(0).getAndarVaga());

                    vagasSimples.remove(0);

                }
            }

            if (quantidadeVagas == 2) {

                if (nroVaga1 == null) {

                    if (vagasDuplas.isEmpty()) {

                        det.setNroVaga1(vagasSimples.get(0).getNroVaga());
                        det.setAndarVaga1(vagasSimples.get(0).getAndarVaga());

                        vagasSimples.remove(0);

                        det.setNroVaga2(vagasSimples.get(0).getNroVaga());
                        det.setAndarVaga2(vagasSimples.get(0).getAndarVaga());

                        vagasSimples.remove(0);

                    } else {

                        det.setNroVaga1(vagasDuplas.get(0).getNroVaga());
                        det.setAndarVaga1(vagasDuplas.get(0).getAndarVaga());

                        vagasDuplas.remove(0);

                    }
                } else {

                    det.setNroVaga2(vagasSimples.get(0).getNroVaga());
                    det.setAndarVaga2(vagasSimples.get(0).getAndarVaga());

                    vagasSimples.remove(0);
                }
            }
        });
    }

    private List<VagasEntity> embaralhaVagasDuplas() {

        List<VagasEntity> vagasDuplas = vagasRepository.findByEnfrenteDepositoAndTipoVaga(FALSO, DUPLA);

        Collections.shuffle(vagasDuplas);

        return vagasDuplas;
    }

    private List<VagasEntity> embaralhaVagasSimples() {

        List<VagasEntity> vagasSimples = vagasRepository.findByEnfrenteDepositoAndTipoVaga(FALSO, SIMPLES);

        Collections.shuffle(vagasSimples);

        return vagasSimples;
    }

    private static void atualizaVagasEnfrenteAoDeposito(List<VagasEntity> vagas, List<ResultadoEntity> resultadoEntities) {

        resultadoEntities.forEach(
                det -> {

                    Integer idVaga = det.getIdVagaDeposito();

                    if (idVaga != null) {

                        Optional<VagasEntity> dadosVaga = vagas.stream()
                                .filter(f -> Objects.equals(f.getIdVaga(), idVaga))
                                .findFirst();

                        String nroVaga = dadosVaga.get().getNroVaga();
                        String andarVaga = dadosVaga.get().getAndarVaga();

                        det.setNroVaga1(nroVaga);
                        det.setAndarVaga1(andarVaga);

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
