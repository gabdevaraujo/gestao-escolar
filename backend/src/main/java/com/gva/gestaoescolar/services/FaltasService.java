package com.gva.gestaoescolar.services;

import java.util.List;

import com.gva.gestaoescolar.entities.Falta;

import org.springframework.stereotype.Service;

@Service
public interface FaltasService {

    public Falta getById(Long id);

    public List<Falta> getByAlunoId(Long alunoId);

    public List<Falta> getByAlunoAndBimestreId(Long alunoId, Long bimestreId);

    public Falta create(Falta falta);

    public Falta update(Long id, Falta falta);
    
}
