import { Avaliacao } from "./Avaliacao.model";
import { Faltas } from "./Faltas";

export class Bimestre {

   id;
   nome;
   avs: Avaliacao[];
  faltas: Faltas[];
}
