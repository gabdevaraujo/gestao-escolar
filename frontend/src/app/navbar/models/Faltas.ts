import { Aluno } from './Aluno.model';
import { Bimestre } from './Bimestre.model';

export class Faltas {

  id: Number;
  qtd: Number;
  bimestre: Bimestre;
  aluno: Aluno;
}
