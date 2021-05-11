import { Injectable } from '@angular/core';
import { Aluno } from '../navbar/models/Aluno.model';
import { GenericService } from './genericService.service';

@Injectable({
  providedIn: 'root',
})
export class AlunosService {

  alunos: Aluno[];

  constructor(private genericService: GenericService) {}

  getAlunos(){
    return this.genericService.get("alunos")
      .subscribe((dados) =>this.alunos = dados);
  }
}
