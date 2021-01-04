import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StartpageComponent } from './startpage/startpage.component'
import { NewProjectComponent } from './new-project/new-project.component'
import { ProjectComponent } from './project/project.component'
import { JmhReportComponent } from './jmh-report/jmh-report.component'
import { GatlingReportComponent } from './gatling-report/gatling-report.component'
import { CucumberReportComponent } from './cucumber-report/cucumber-report.component'
import { JunitReportComponent } from './junit-report/junit-report.component'
import { PageNotFoundComponent } from './page-not-found/page-not-found.component'

const routes: Routes = [
  { path: '', component: StartpageComponent },
  { path: 'new-project', component: NewProjectComponent },
  { path: 'projects', component: ProjectComponent },
  { path: 'projects/:projectId/junit', component: JunitReportComponent },
  { path: 'projects/:projectId/junit/:testCase', component: JunitReportComponent }, // TODO
  { path: 'projects/:projectId/cucumber', component: CucumberReportComponent },
  { path: 'projects/:projectId/cucumber/:scenario', component: CucumberReportComponent }, // TODO
  { path: 'projects/:projectId/jmh', component: JmhReportComponent },
  { path: 'projects/:projectId/jmh/:benchmark', component: JmhReportComponent }, // TODO
  { path: 'projects/:projectId/gatling', component: GatlingReportComponent },

  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
