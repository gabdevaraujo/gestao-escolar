package com.gva.gestaoescolar.repositories;

import java.util.List;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    
    public List<Avaliacao> findByAluno(Aluno aluno);

    public List<Avaliacao> findByAlunoAndBimestre(Aluno aluno, Bimestre bimestre);


}
