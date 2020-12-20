import { TestBed } from '@angular/core/testing';

import { DokiProjectApiService } from './doki-project-api.service';

describe('DokiProjectApiService', () => {
  let service: DokiProjectApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DokiProjectApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
