import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JunitReportListComponent } from './junit-report-list.component';

describe('JunitReportListComponent', () => {
  let component: JunitReportListComponent;
  let fixture: ComponentFixture<JunitReportListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JunitReportListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JunitReportListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
