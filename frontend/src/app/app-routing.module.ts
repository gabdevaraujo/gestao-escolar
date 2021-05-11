import { FormFrequenciaComponent } from './components/form-frequencia/form-frequencia.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableAlunosComponent } from './components/table-alunos/table-alunos.component';
import { FormAvalicaoComponent } from './components/form-avalicao/form-avalicao.component';

const routes: Routes = [
  { path: '', component: TableAlunosComponent },
  { path: ':id/frequencia', component: FormFrequenciaComponent },
  { path: ':id/avaliacoes', component: FormAvalicaoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
