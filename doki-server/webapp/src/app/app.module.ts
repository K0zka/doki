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

@NgModule({
  declarations: [
    AppComponent,
    StartpageComponent,
    ProjectComponent,
    JunitReportComponent,
    CucumberReportComponent,
    JmhReportComponent,
    GatlingReportComponent,
    NewProjectComponent
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
