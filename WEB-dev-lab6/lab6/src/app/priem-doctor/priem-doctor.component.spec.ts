import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriemDoctorComponent } from './priem-doctor.component';

describe('PriemDoctorComponent', () => {
  let component: PriemDoctorComponent;
  let fixture: ComponentFixture<PriemDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriemDoctorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriemDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
