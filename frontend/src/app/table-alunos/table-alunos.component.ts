import { Aluno } from './../navbar/models/Aluno.model';
import { Component, OnInit } from '@angular/core';
import { AlunosService } from '../services/alunos.service';
import { GenericService } from '../services/genericService.service';

@Component({
  selector: 'app-table-alunos',
  templateUrl: './table-alunos.component.html',
  styleUrls: ['./table-alunos.component.css']
})
export class TableAlunosComponent implements OnInit {

  alunos: Aluno[];

  constructor(private genericService: GenericService) { }

  ngOnInit(): void {
    this.getAlunos();
  }

  getAlunos(){
    return this.genericService.get("alunos")
      .subscribe((dados) =>this.alunos = dados);
  }

}
