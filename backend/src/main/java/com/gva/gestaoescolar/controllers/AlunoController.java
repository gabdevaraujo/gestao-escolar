package com.gva.gestaoescolar.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Falta;
import com.gva.gestaoescolar.entities.dtos.AlunoDTO;
import com.gva.gestaoescolar.entities.dtos.AlunoSituacaoDTO;
import com.gva.gestaoescolar.entities.dtos.AvaliacaoPorAlunoDTO;
import com.gva.gestaoescolar.entities.dtos.FaltasDTO;
import com.gva.gestaoescolar.services.FaltasService;
import com.gva.gestaoescolar.services.Impl.AlunoServiceImpl;
import com.gva.gestaoescolar.services.Impl.AvaliacaoServiceImpl;
import com.gva.gestaoescolar.services.Impl.FaltasServiceImpl;

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

    @Autowired
    private AvaliacaoServiceImpl avService;

    @Autowired
    private FaltasServiceImpl faltasService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAll() {
        
        List<Aluno> items = service.getAll();
        List<AlunoDTO> dtos = items.stream().map( x -> new AlunoDTO(x)).collect(Collectors.toList());

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoDTO> getById(@PathVariable("id") String id){
        Aluno aluno = service.getById(Long.valueOf(id));
        AlunoDTO dto = new AlunoDTO(aluno);
        return ResponseEntity.ok(dto);
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
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
        service.delete(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    
    @PutMapping("{id}/situacao")
    public ResponseEntity<Aluno> updateSituacao(@PathVariable("id") String id, @RequestBody Aluno aluno) {
        Aluno obj  = aluno;
        obj.setId(Long.valueOf(id));
        service.setSituacao(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/situacao")
    public ResponseEntity<AlunoSituacaoDTO> getSituacao(@PathVariable("id") String id){
        Aluno aluno = service.getSituacaoByAlunoId(Long.valueOf(id));
        System.out.println("Aqui" + aluno.getId() + aluno.getSituacao());
        AlunoSituacaoDTO dto = new AlunoSituacaoDTO(aluno);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("{alunoId}/avaliacoes")
    public ResponseEntity<List<AvaliacaoPorAlunoDTO>> getByAlunoId(@PathVariable("alunoId") String alunoId){
        List<Avaliacao> avs = avService.getByAlunoId(Long.valueOf(alunoId));
        List<AvaliacaoPorAlunoDTO> listDto = avs.stream().map( obj -> new AvaliacaoPorAlunoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping("{alunoId}/{bimestreId}/avaliacoes")
    public ResponseEntity<List<AvaliacaoPorAlunoDTO>> getByAlunoBimestreId(@PathVariable("alunoId") String alunoId, @PathVariable("bimestreId") String bimestreId){
        List<Avaliacao> avs = avService.getByAlunoBimestreId(Long.valueOf(alunoId), Long.valueOf(bimestreId));
        List<AvaliacaoPorAlunoDTO> listDto = avs.stream().map( obj -> new AvaliacaoPorAlunoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @PostMapping("avaliacoes")
    public ResponseEntity<Avaliacao> createAvalicao(@RequestBody Avaliacao av){
        Avaliacao avaliacao = avService.create(av);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{alunoId}/faltas")
    public ResponseEntity<List<FaltasDTO>> getFaltasByAlunoId(@PathVariable("alunoId") String alunoId){
        List<Falta> faltas = faltasService.getByAlunoId(Long.valueOf(alunoId));
        List<FaltasDTO> listDto = faltas.stream().map( obj -> new FaltasDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping("{alunoId}/{bimestreId}/faltas")
    public ResponseEntity<List<FaltasDTO>> getFaltasByAlunoId(@PathVariable("alunoId") String alunoId, @PathVariable("bimestreId") String bimestreId){
        List<Falta> faltas = faltasService.getByAlunoAndBimestreId(Long.valueOf(alunoId), Long.valueOf(bimestreId));
        List<FaltasDTO> listDto = faltas.stream().map( obj -> new FaltasDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }
    
    @PostMapping("faltas")
    public ResponseEntity<Falta> create(@RequestBody FaltasDTO falta){
        Falta flt = faltasService.create(faltasService.fromDtotoFalta(falta));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(flt.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("faltas/{faltaId}")
    public ResponseEntity<Falta> update(@PathVariable("faltaId") String faltaId, @RequestBody FaltasDTO falta){
        Falta flt = faltasService.update(Long.valueOf(faltaId), faltasService.fromDtotoFalta(falta));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(flt.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}