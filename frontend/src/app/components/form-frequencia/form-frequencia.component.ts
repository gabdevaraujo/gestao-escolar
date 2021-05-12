import { Frequencia } from './../../models/Frequencia.model';
import { GenericService } from './../../services/genericService.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-form-frequencia',
  templateUrl: './form-frequencia.component.html',
  styleUrls: ['./form-frequencia.component.css']
})
export class FormFrequenciaComponent implements OnInit {

  frequencia: Frequencia = new Frequencia();
  bimestres = [1, 2, 3, 4];
  opEnd: boolean;

  constructor(
    private genericService: GenericService,
    private activatedRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = Number(this.activatedRouter.snapshot.paramMap.get('id'));
    this.frequencia.alunoId = id;
    console.log(id);

  }

  lancarFrequencia() {
    this.frequencia.bimestreId = Number(this.frequencia.bimestreId);
    this.frequencia.qtd = Number(this.frequencia.qtd);
    this.genericService.post("alunos/faltas", this.frequencia)
      .subscribe(dados => this.opEnd = true);
  }

  teste(evento) {
    console.log(evento);

  }

  imprimeForm() {
    this.lancarFrequencia();
    console.log("Frequencia lançadas: " , this.frequencia);
  }
}
