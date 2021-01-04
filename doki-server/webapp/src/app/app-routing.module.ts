import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StartpageComponent } from './startpage/startpage.component'
import { NewProjectComponent } from './new-project/new-project.component'
import { ProjectComponent } from './project/project.component'
import { ProjectListComponent } from './project-list/project-list.component'
import { JmhReportComponent } from './jmh-report/jmh-report.component'
import { JmhReportListComponent } from './jmh-report-list/jmh-report-list.component'
import { GatlingReportComponent } from './gatling-report/gatling-report.component'
import { GatlingReportListComponent } from './gatling-report-list/gatling-report-list.component'
import { CucumberReportComponent } from './cucumber-report/cucumber-report.component'
import { CucumberReportListComponent } from './cucumber-report-list/cucumber-report-list.component'
import { JunitReportComponent } from './junit-report/junit-report.component'
import { JunitReportListComponent } from './junit-report-list/junit-report-list.component'
import { PageNotFoundComponent } from './page-not-found/page-not-found.component'

const routes: Routes = [
  { path: '', component: StartpageComponent },
  { path: 'new-project', component: NewProjectComponent },
  { path: 'projects', component: ProjectListComponent },
  { path: 'projects/:projectId', component: ProjectComponent },
  { path: 'projects/:projectId/junit', component: JunitReportListComponent },
  { path: 'projects/:projectId/junit/:testCase', component: JunitReportComponent },
  { path: 'projects/:projectId/cucumber', component: CucumberReportListComponent },
  { path: 'projects/:projectId/cucumber/:scenario', component: CucumberReportComponent },
  { path: 'projects/:projectId/jmh', component: JmhReportListComponent },
  { path: 'projects/:projectId/jmh/:benchmark', component: JmhReportComponent },
  { path: 'projects/:projectId/gatling', component: GatlingReportListComponent },
  { path: 'projects/:projectId/gatling/:benchmark', component: GatlingReportComponent },

  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
