import { TestBed } from '@angular/core/testing';

import { DokiApiService } from './doki-api.service';

describe('DokiApiService', () => {
  let service: DokiApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DokiApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
