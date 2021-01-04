import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CucumberReportListComponent } from './cucumber-report-list.component';

describe('CucumberReportListComponent', () => {
  let component: CucumberReportListComponent;
  let fixture: ComponentFixture<CucumberReportListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CucumberReportListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CucumberReportListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
