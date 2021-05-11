package com.gva.gestaoescolar.repositories;

import java.util.List;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.Falta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaltaRepository extends JpaRepository<Falta, Long> {
    
    public List<Falta> findByAluno(Aluno aluno);

    public List<Falta> findByAlunoAndBimestre(Aluno aluno, Bimestre bimestre);
}
