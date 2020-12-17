import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatlingReportComponent } from './gatling-report.component';

describe('GatlingReportComponent', () => {
  let component: GatlingReportComponent;
  let fixture: ComponentFixture<GatlingReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GatlingReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GatlingReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
