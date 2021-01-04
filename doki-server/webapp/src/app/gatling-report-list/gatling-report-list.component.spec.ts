import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatlingReportListComponent } from './gatling-report-list.component';

describe('GatlingReportListComponent', () => {
  let component: GatlingReportListComponent;
  let fixture: ComponentFixture<GatlingReportListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GatlingReportListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GatlingReportListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
