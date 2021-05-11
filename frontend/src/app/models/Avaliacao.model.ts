import { Aluno } from './Aluno.model';
import { Bimestre } from './Bimestre.model';

export class Avaliacao{

  id: Number;
  tipoAv: Number;
  peso: Number;
  bimestre: Bimestre;
  aluno: Aluno;
}
