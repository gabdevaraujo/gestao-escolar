import { Aluno } from './Aluno.model';
import { Bimestre } from './Bimestre.model';

export class Avaliacao{

  id: number;
  tipoAv: number;
  peso: number;
  bimestreId: number;
  alunoId: number;
}
