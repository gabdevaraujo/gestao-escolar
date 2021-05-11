
import { GenericService } from './../../services/genericService.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-form-frequencia',
  templateUrl: './form-frequencia.component.html',
  styleUrls: ['./form-frequencia.component.css']
})
export class FormFrequenciaComponent implements OnInit {



  constructor(
    private genericService: GenericService,
    private activatedRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.paramMap.get('id');

    console.log(id);

  }

  /* lancarFaltas() {
    this.genericService.put("alunos/faltas", this.falta)
      .subscribe(dados => console.log(dados) //save or update
      );
  }

  teste(evento) {
    console.log(evento);

  }

  imprimeForm() {
    this.lancarFaltas();
    console.log("Faltas lançadas: " , this.falta);

  } */
}
