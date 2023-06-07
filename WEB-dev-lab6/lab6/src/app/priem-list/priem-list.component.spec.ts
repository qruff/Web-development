import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriemListComponent } from './priem-list.component';

describe('PriemListComponent', () => {
  let component: PriemListComponent;
  let fixture: ComponentFixture<PriemListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriemListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
