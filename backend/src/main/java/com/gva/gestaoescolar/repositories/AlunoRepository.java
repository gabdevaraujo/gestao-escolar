package com.gva.gestaoescolar.repositories;

import com.gva.gestaoescolar.entities.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    
}
