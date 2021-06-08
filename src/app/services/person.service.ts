import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private baseUrl = "http://localhost:8080/characters";
  constructor(private http: HttpClient) { }
  
  getlistCharacter(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
