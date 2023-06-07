import { TestBed } from '@angular/core/testing';

import { PriemService } from './priem.service';

describe('PriemService', () => {
  let service: PriemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PriemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
