package com.gva.gestaoescolar.services.Impl;

import java.util.List;
import java.util.Optional;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.enums.Situacao;
import com.gva.gestaoescolar.repositories.AlunoRepository;
import com.gva.gestaoescolar.repositories.AvaliacaoRepository;
import com.gva.gestaoescolar.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AvaliacaoRepository avRepository;

    @Autowired
    private FaltasServiceImpl faltasService;

    @Override
    public List<Aluno> getAll() {
        List<Aluno> alunos = repository.findAll();
        return alunos;
    }

    @Override
    public Aluno getById(Long id) {
        
        Optional<Aluno> aluno = repository.findById(id);

        return aluno.orElseThrow(
            () -> new com.gva.gestaoescolar.services.exeptions.ObjectNotFoundException(
                "Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()
            ) 
        );
    }

    public Aluno getSituacaoByAlunoId(Long id) {
        
        Optional<Aluno> aluno = Optional.of(repository.findById(id).get());
        Aluno al = updateSituacao(aluno.get());
        return repository.save(al);
    }

    @Override
    public Aluno create(Aluno aluno) {
        Optional<Aluno> optAluno = Optional.of(repository.save(aluno));

        return optAluno.orElseThrow(
            () -> new com.gva.gestaoescolar.services.exeptions.ObjectNotFoundException(
                "Não foi possível criar este aluno: " + aluno.getNome()
            )
        );
    }

    @Override
    public Aluno update(Aluno aluno) {
        Aluno newObj = getById(aluno.getId());
        updateNome(newObj, aluno);
        updateSituacao(aluno);
        return repository.save(newObj);
    }

    public Aluno setSituacao(Aluno aluno){
        Aluno newObj = getById(aluno.getId());
        updateSituacao(aluno);
        return repository.save(newObj);
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = getById(id);
        repository.delete(aluno);     
    }

    @Override
    public Avaliacao createAvalicao(Avaliacao av){
        Optional<Avaliacao> avaliacao = Optional.of(avRepository.save(av));

        return avaliacao.orElseThrow(
            () -> new com.gva.gestaoescolar.services.exeptions.ObjectNotFoundException(
                "Não foi possível criar esta avaliação para o aluno: " + avaliacao.get().getAluno().getNome()
            )
        );
    }
    
    public void updateNome(Aluno newObj, Aluno obj){
        newObj.setNome(obj.getNome());
    }

    public Aluno updateSituacao(Aluno aluno){
        Aluno newObj = aluno;
        Double totalNotas = .0;
        Double mediaFinal = .0;
        for(Avaliacao av : aluno.getAvs()){
            totalNotas += av.getPeso();
        }
        mediaFinal = totalNotas / 4;
        Double porcFaltas =  faltasService.getTotalFaltas(aluno.getId()) * 100 / 160.0;
        
        if(mediaFinal >= 6 && porcFaltas < 25.0){
            newObj.setSituacao(Situacao.toEnum(1));
        }
            
        
        if(mediaFinal < 5.0 || porcFaltas >= 25.0){
            newObj.setSituacao(Situacao.toEnum(2));
        }
            

        if(mediaFinal >= 5.0 && mediaFinal < 6.0){
            newObj.setSituacao(Situacao.toEnum(3));
        }
            
        System.out.println("Situação " + newObj.getSituacao());
        
        return newObj;
    }

}
