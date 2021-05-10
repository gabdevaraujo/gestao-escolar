package com.gva.gestaoescolar.services.Impl;

import java.util.List;
import java.util.Optional;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.repositories.AlunoRepository;
import com.gva.gestaoescolar.repositories.AvaliacapRepository;
import com.gva.gestaoescolar.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AvaliacapRepository avRepository;

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
        updateData(newObj, aluno);
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
    
    public void updateData(Aluno newObj, Aluno obj){
        newObj.setNome(obj.getNome());
    }
}
