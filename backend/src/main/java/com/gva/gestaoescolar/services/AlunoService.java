package com.gva.gestaoescolar.services;

import java.util.List;
import java.util.Optional;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.enums.TipoAv;

import org.springframework.stereotype.Service;

@Service
public interface AlunoService {

    public List<Aluno> getAll();

    public Aluno getById(Long id);

    public Aluno create(Aluno aluno);

    public Aluno update(Aluno aluno);

    public void delete(Long id);
    
    public Avaliacao createAvalicao(Avaliacao av);
}
