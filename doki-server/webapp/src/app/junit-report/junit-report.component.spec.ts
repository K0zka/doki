import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JunitReportComponent } from './junit-report.component';

describe('JunitReportComponent', () => {
  let component: JunitReportComponent;
  let fixture: ComponentFixture<JunitReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JunitReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JunitReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
