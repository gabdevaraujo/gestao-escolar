import { TipoAv } from './../../models/TipoAv.model';
import { Component, EventEmitter, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Avaliacao } from 'src/app/models/Avaliacao.model';
import { GenericService } from 'src/app/services/genericService.service';


@Component({
  selector: 'app-form-avalicao',
  templateUrl: './form-avalicao.component.html',
  styleUrls: ['./form-avalicao.component.css']
})
export class FormAvalicaoComponent implements OnInit {

  av: Avaliacao = new Avaliacao();
  bimestres = [1, 2, 3, 4];
  opEnd: boolean;
  tiposAvs: TipoAv[] = [
    {
      id: 1,
      descricao: "PARTICIPACAO EM SALA DE AULA"
    },
    {
      id: 2,
      descricao: "ENTREGA DE TAREFAS"
    },
    {
      id: 3,
      descricao: "TRABALHO BIMESTRAL"
    },
    {
      id: 4,
      descricao: "PROVA BIMESTRAL"
    },
  ];

  avs: Avaliacao[];
  reqBim: number;
  notaTotal: number;


  constructor(
    private genericService: GenericService,
    private activatedRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const alunoId = this.activatedRouter.snapshot.paramMap.get('id');
    this.av.alunoId = Number(alunoId);
  }

  ngOnChanges(changes: SimpleChanges) {

  }

  lancarAvaliacao(){
    this.genericService.post('alunos/avaliacoes', this.av)
      .subscribe(dados => this.opEnd = true);
  }

  getAvaliacoesPorBimestre(event){
    this.genericService.get(`alunos/${this.av.alunoId}/${event}/avaliacoes`)
      .subscribe(dados => {
        console.log(dados);

        this.avs = dados;
        this.notaTotal = this.avs.map(a => a.peso).reduce((x,y) => x + y);
      });
  }
}
