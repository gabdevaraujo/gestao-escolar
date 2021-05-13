import { Injectable } from '@angular/core';
import { Aluno } from '../models/Aluno.model';
import { GenericService } from './genericService.service';

@Injectable({
  providedIn: 'root',
})
export class AlunosService {

  constructor(private genericService: GenericService) {}

  getAlunos(){
    this.genericService.get("alunos");
  }

  getAlunosById(alunoId){
    this.genericService.get(`alunos/${alunoId}`);
  }
}
