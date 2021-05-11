package com.gva.gestaoescolar.services;

import java.util.List;

import com.gva.gestaoescolar.entities.Avaliacao;


import org.springframework.stereotype.Service;

@Service
public interface AvaliacaoService {

    public List<Avaliacao> getByAlunoId(Long alunoId);

    public List<Avaliacao> getByAlunoBimestreId(Long alunoId, Long bimestreId);
    
    public Avaliacao create(Avaliacao av);

    
}
