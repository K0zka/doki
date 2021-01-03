import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DokiProjectApiService {

  constructor(private httpClient : HttpClient) { }

  public createProject(project) {
    return this.httpClient.post('api/v1/project', project);
  }


}
