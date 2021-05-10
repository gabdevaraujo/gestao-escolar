package com.gva.gestaoescolar.repositories;

import com.gva.gestaoescolar.entities.Avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacapRepository extends JpaRepository<Avaliacao, Long> {
    
}
