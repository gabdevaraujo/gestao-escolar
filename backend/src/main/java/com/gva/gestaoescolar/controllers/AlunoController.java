package com.gva.gestaoescolar.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.repositories.AlunoRepository;
import com.gva.gestaoescolar.services.Impl.AlunoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/alunos")
class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        
        List<Aluno> items = service.getAll();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> getById(@PathVariable("id") String id){
        Aluno aluno = service.getById(Long.valueOf(id));
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno alunoDB = service.create(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoDB.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") String id, @RequestBody Aluno aluno) {
        Aluno obj  = aluno;
        obj.setId(Long.valueOf(id));
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
        service.delete(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("avaliacoes")
    public ResponseEntity<Avaliacao> createAvalicao(@RequestBody Avaliacao av){
        Avaliacao avaliacao = service.createAvalicao(av);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}