package com.gva.gestaoescolar.services.Impl;

import java.util.List;
import java.util.Optional;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.Falta;
import com.gva.gestaoescolar.entities.dtos.FaltasDTO;
import com.gva.gestaoescolar.repositories.AvaliacaoRepository;
import com.gva.gestaoescolar.repositories.FaltaRepository;
import com.gva.gestaoescolar.services.AvaliacaoService;
import com.gva.gestaoescolar.services.BimestreService;
import com.gva.gestaoescolar.services.FaltasService;
import com.gva.gestaoescolar.services.exeptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaltasServiceImpl implements FaltasService{

    @Autowired
    private FaltaRepository repository;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Autowired
    private BimestreService bimestreService;

    @Override
    public Falta getById(Long id) {
        Optional<Falta> falta = repository.findById(id);
        return falta.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não existem falta para este id: " + id
            )
        );
    }

    @Override
    public List<Falta> getByAlunoId(Long alunoId) {
        Aluno aluno = alunoService.getById(alunoId);
        Optional<List<Falta>> faltas = Optional.of(repository.findByAluno(aluno));
        return faltas.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não existem faltas para este aluno: " + aluno.getNome()
            )
        );
    }

    @Override
    public List<Falta> getByAlunoAndBimestreId(Long alunoId, Long bimestreId) {
        Aluno aluno = alunoService.getById(alunoId);
        Bimestre bimestre = bimestreService.getById(bimestreId);
        Optional<List<Falta>> faltas = Optional.of(repository.findByAlunoAndBimestre(aluno, bimestre));
        return faltas.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não existem faltas para este aluno nesse bimestre: " + bimestre.getNome()
            )
        );
    }

    @Override
    public Falta create(Falta falta) {
        List<Falta> faltas = getByAlunoAndBimestreId(falta.getAluno().getId(), falta.getBimestre().getId());
        System.out.println(faltas);
        if (!faltas.isEmpty()) {
            for(Falta f : faltas){
                repository.delete(f);
            }
        }
        
        Optional<Falta> optFlt = Optional.of(repository.save(falta));

        return optFlt.orElseThrow(
            () -> new ObjectNotFoundException(
                "Não foi possível lançar esta falta"
            )
        );
    }

    @Override
    public Falta update(Long id, Falta falta) {
        Falta flt = getById(id);
        updateFalta(falta, flt);

        return Optional.of(repository.save(flt)).orElseThrow(
            () -> new ObjectNotFoundException(
                "Não foi possível atualizar esta falta"
            )
        );
    }

    public Integer getTotalFaltas(Long alunoId){
        Integer totalFaltas = 0;
        for(Falta f : getByAlunoId(alunoId)){
            totalFaltas += f.getQtd();
        }
        return totalFaltas;
    }
    
    public Falta fromDtotoFalta(FaltasDTO dto){
        Falta falta = new Falta();
        falta.setAluno(alunoService.getById(dto.getAlunoId()));
        falta.setBimestre(bimestreService.getById(dto.getBimestreId()));
        falta.setQtd(dto.getQtd());
        return falta;
    }

    public Falta updateFalta(Falta falta, Falta faltaUpdt){
        faltaUpdt.setQtd(falta.getQtd());
        return faltaUpdt;
    }
}
