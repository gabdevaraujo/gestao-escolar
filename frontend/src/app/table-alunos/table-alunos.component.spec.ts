import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableAlunosComponent } from './table-alunos.component';

describe('TableAlunosComponent', () => {
  let component: TableAlunosComponent;
  let fixture: ComponentFixture<TableAlunosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableAlunosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableAlunosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
