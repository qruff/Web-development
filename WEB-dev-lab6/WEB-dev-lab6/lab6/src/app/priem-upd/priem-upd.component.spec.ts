import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriemUpdComponent } from './priem-upd.component';

describe('PriemUpdComponent', () => {
  let component: PriemUpdComponent;
  let fixture: ComponentFixture<PriemUpdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriemUpdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriemUpdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
