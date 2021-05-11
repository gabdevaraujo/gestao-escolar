import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAvalicaoComponent } from './form-avalicao.component';

describe('FormAvalicaoComponent', () => {
  let component: FormAvalicaoComponent;
  let fixture: ComponentFixture<FormAvalicaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAvalicaoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAvalicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
