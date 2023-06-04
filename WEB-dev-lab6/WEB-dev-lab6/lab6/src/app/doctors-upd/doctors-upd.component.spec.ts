import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorsUpdComponent } from './doctors-upd.component';

describe('DoctorsUpdComponent', () => {
  let component: DoctorsUpdComponent;
  let fixture: ComponentFixture<DoctorsUpdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorsUpdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctorsUpdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
