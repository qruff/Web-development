import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientUpdComponent } from './patient-upd.component';

describe('PatientUpdComponent', () => {
  let component: PatientUpdComponent;
  let fixture: ComponentFixture<PatientUpdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientUpdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientUpdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
