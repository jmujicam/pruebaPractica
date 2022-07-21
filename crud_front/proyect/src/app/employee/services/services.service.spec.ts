import { TestBed } from '@angular/core/testing';

import { ServicesEmployee } from './servicesEmployee.service';

describe('ServicesService', () => {
  let service: ServicesEmployee;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicesEmployee);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
