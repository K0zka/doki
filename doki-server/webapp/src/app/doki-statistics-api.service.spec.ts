import { TestBed } from '@angular/core/testing';

import { DokiStatisticsApiService } from './doki-statistics-api.service';

describe('DokiStatisticsApiService', () => {
  let service: DokiStatisticsApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DokiStatisticsApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
