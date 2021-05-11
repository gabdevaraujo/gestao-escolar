import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFrequenciaComponent } from './form-frequencia.component';

describe('FormFrequenciaComponent', () => {
  let component: FormFrequenciaComponent;
  let fixture: ComponentFixture<FormFrequenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormFrequenciaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFrequenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
