package com.gva.gestaoescolar.services;

import java.util.Optional;

import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.repositories.BimestreRepository;
import com.gva.gestaoescolar.services.exeptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BimestreService {

    @Autowired
    private BimestreRepository repository;

    public Bimestre getById(Long id){
        Optional<Bimestre> bimestre = repository.findById(id);
        return bimestre.orElseThrow(
            () ->  new ObjectNotFoundException(
                "Bimestre não encontrado:  " + bimestre.get().getNome()
            )
        );
    }

    
}
