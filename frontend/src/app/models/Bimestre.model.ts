import { Avaliacao } from './Avaliacao.model';
import { Frequencia } from './Frequencia.model';

export class Bimestre {
  id;
  inicio: Date;
  fim: Date;
  avs: Avaliacao[];
  frequencia: Frequencia[];
}
