import { Component } from '@angular/core';
import { faFileAlt, faGlasses, faCode, faChartBar, faStopwatch, faCheckSquare, faCheck } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  faFileAlt = faFileAlt;
  faGlasses = faGlasses;
  faCode = faCode;
  faChartBar = faChartBar;
  faStopWatch = faStopwatch;
  faCheckSquare = faCheckSquare;
  faCheck = faCheck;
}
