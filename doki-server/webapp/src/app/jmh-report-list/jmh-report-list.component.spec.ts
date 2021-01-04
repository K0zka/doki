import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JmhReportListComponent } from './jmh-report-list.component';

describe('JmhReportListComponent', () => {
  let component: JmhReportListComponent;
  let fixture: ComponentFixture<JmhReportListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JmhReportListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JmhReportListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
