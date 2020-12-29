import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StartpageComponent } from './startpage/startpage.component'
import { NewProjectComponent } from './new-project/new-project.component'
import { ProjectComponent } from './project/project.component'
import { JmhReportComponent } from './jmh-report/jmh-report.component'
import { GatlingReportComponent } from './gatling-report/gatling-report.component'
import { PageNotFoundComponent } from './page-not-found/page-not-found.component'

const routes: Routes = [
  { path: '', component: StartpageComponent },
  { path: 'new-project', component: NewProjectComponent },
  { path: 'project', component: ProjectComponent },
  { path: 'project/**/jmh', component: JmhReportComponent },
  { path: 'project/**/gatling', component: GatlingReportComponent },

  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
