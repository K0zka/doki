import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgxEchartsModule } from 'ngx-echarts';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { StartpageComponent } from './startpage/startpage.component';
import { ProjectComponent } from './project/project.component';
import { JunitReportComponent } from './junit-report/junit-report.component';
import { CucumberReportComponent } from './cucumber-report/cucumber-report.component';
import { JmhReportComponent } from './jmh-report/jmh-report.component';
import { GatlingReportComponent } from './gatling-report/gatling-report.component';
import { HttpClientModule } from '@angular/common/http';
import { NewProjectComponent } from './new-project/new-project.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { JunitReportListComponent } from './junit-report-list/junit-report-list.component';
import { CucumberReportListComponent } from './cucumber-report-list/cucumber-report-list.component';
import { JmhReportListComponent } from './jmh-report-list/jmh-report-list.component';
import { GatlingReportListComponent } from './gatling-report-list/gatling-report-list.component';
import { ProjectListComponent } from './project-list/project-list.component';

@NgModule({
  declarations: [
    AppComponent,
    StartpageComponent,
    ProjectComponent,
    JunitReportComponent,
    CucumberReportComponent,
    JmhReportComponent,
    GatlingReportComponent,
    NewProjectComponent,
    PageNotFoundComponent,
    JunitReportListComponent,
    CucumberReportListComponent,
    JmhReportListComponent,
    GatlingReportListComponent,
    ProjectListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FontAwesomeModule,
    NgxEchartsModule.forRoot({
          echarts: () => import('echarts')
        })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
