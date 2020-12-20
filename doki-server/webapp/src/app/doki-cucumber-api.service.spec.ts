import { TestBed } from '@angular/core/testing';

import { DokiCucumberApiService } from './doki-cucumber-api.service';

describe('DokiCucumberApiService', () => {
  let service: DokiCucumberApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DokiCucumberApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
