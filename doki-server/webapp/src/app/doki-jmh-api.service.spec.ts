import { TestBed } from '@angular/core/testing';

import { DokiJmhApiService } from './doki-jmh-api.service';

describe('DokiJmhApiService', () => {
  let service: DokiJmhApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DokiJmhApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
