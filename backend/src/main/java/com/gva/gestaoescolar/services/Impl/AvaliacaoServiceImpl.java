package com.gva.gestaoescolar.services.Impl;

import java.util.List;
import java.util.Optional;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.repositories.AvaliacaoRepository;
import com.gva.gestaoescolar.services.AvaliacaoService;
import com.gva.gestaoescolar.services.BimestreService;
import com.gva.gestaoescolar.services.exeptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService{

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private BimestreService bimestreService;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Override
    public List<Avaliacao> getByAlunoId(Long alunoId) {
        Aluno aluno = alunoService.getById(alunoId);
        Optional<List<Avaliacao>> avs = Optional.of(repository.findByAluno(aluno));
        return avs.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não existem avaliações para este aluno: " + aluno.getNome()
            )
        );
    }

    @Override
    public List<Avaliacao> getByAlunoBimestreId(Long alunoId, Long bimestreId){
        Aluno aluno = alunoService.getById(alunoId);
        Bimestre bimestre = bimestreService.getById(bimestreId);
        Optional<List<Avaliacao>> avs = Optional.of(repository.findByAlunoAndBimestre(aluno, bimestre));
        return avs.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não existem avaliações para este aluno neste bimestre: " + bimestre.getNome()
            )
        );
    }


    @Override
    public Avaliacao create(Avaliacao av) {
        Optional<Avaliacao> optAv = Optional.of(repository.save(av));

        return optAv.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não foi possível criar este aluno: " + av.getAluno().getNome()
            )
        );
    }

}
