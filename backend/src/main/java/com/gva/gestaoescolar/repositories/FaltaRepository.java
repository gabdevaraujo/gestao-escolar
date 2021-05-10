package com.gva.gestaoescolar.repositories;

import com.gva.gestaoescolar.entities.Falta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaltaRepository extends JpaRepository<Falta, Long> {
    
}
