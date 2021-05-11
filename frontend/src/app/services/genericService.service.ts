import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class GenericService {
  private baseUrl: string = environment.baseUrl;

  constructor(
    private httpClient: HttpClient,
  ) {}

  get(route: string, options?: any): Observable<any> {
    return options
      ? this.httpClient.get(`${this.baseUrl}/${route}`, options)
      : this.httpClient.get(`${this.baseUrl}/${route}`);
  }

  post(route: string, value: any, options?: any): Observable<any> {
    return options
      ? this.httpClient.post(`${this.baseUrl}/${route}`, value, options)
      : this.httpClient.post(`${this.baseUrl}/${route}`, value);
  }

  put(route: string, value: any, options?: any): Observable<any> {
    return options
      ? this.httpClient.put(`${this.baseUrl}/${route}`, value, options)
      : this.httpClient.put(`${this.baseUrl}/${route}`, value);
  }

  delete(route: string): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${route}`);
  }
}
