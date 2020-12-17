import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JmhReportComponent } from './jmh-report.component';

describe('JmhReportComponent', () => {
  let component: JmhReportComponent;
  let fixture: ComponentFixture<JmhReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JmhReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JmhReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
