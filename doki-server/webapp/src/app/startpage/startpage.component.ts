import { Component, OnInit } from '@angular/core';
import { DokiStatisticsApiService } from '../doki-statistics-api.service'

@Component({
  selector: 'app-startpage',
  templateUrl: './startpage.component.html',
  styleUrls: ['./startpage.component.css']
})
export class StartpageComponent implements OnInit {

  constructor(private statService : DokiStatisticsApiService) {

  }

  totalProjects;

  ngOnInit(): void {
    this.statService.getStats().subscribe( (data)=>{
      this.totalProjects =  data['totalProjects'];
    }
    );
  }

}
