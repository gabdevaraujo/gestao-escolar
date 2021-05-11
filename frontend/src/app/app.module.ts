import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { TableAlunosComponent } from './components/table-alunos/table-alunos.component';
import { FormFrequenciaComponent } from './components/form-frequencia/form-frequencia.component';
import { FormsModule } from '@angular/forms';
import { FormAvalicaoComponent } from './components/form-avalicao/form-avalicao.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TableAlunosComponent,
    FormFrequenciaComponent,
    FormAvalicaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
