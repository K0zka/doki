import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CucumberReportComponent } from './cucumber-report.component';

describe('CucumberReportComponent', () => {
  let component: CucumberReportComponent;
  let fixture: ComponentFixture<CucumberReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CucumberReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CucumberReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
