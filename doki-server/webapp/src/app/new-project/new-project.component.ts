import { Component, OnInit } from '@angular/core';
import { DokiProjectApiService } from '../doki-project-api.service'

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

  constructor(private projectService : DokiProjectApiService) { }

  ngOnInit(): void {
  }

  createProject() {
    this.projectService.createProject(null).subscribe( (data)=> {
      // WHAT?
    });
  }

}
