import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DokiStatisticsApiService {

  constructor(private httpClient : HttpClient) { }

  public getStats() {
    return this.httpClient.get('api/v1/statistics')
  }
}
