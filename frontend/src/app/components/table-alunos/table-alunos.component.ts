
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Aluno } from '../../models/Aluno.model';
import { AlunosService } from '../../services/alunos.service';
import { GenericService } from '../../services/genericService.service';

@Component({
  selector: 'app-table-alunos',
  templateUrl: './table-alunos.component.html',
  styleUrls: ['./table-alunos.component.css']
})
export class TableAlunosComponent implements OnInit {

  alunos: Aluno[];

  constructor(
    private genericService: GenericService,
    private route: Router
  ) { }

  ngOnInit(): void {
    this.getAlunos();
  }

  getAlunos(){
    return this.genericService.get("alunos")
      .subscribe((dados) =>{
        console.log(dados);

        this.alunos = dados});

  }

  lancarFaltas(alunoId : number){
    this.route.navigateByUrl(`alunos/${alunoId}/frequencia`);
  }

  lancarNotas(alunoId : number){
    this.route.navigateByUrl(`alunos/${alunoId}/avaliacoes`);
  }

}
