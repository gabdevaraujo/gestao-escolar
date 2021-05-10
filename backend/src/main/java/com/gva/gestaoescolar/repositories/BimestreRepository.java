package com.gva.gestaoescolar.repositories;

import com.gva.gestaoescolar.entities.Bimestre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BimestreRepository extends JpaRepository<Bimestre, Long>{
    
}
