import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private baseUrl = "http://localhost:8080/characters";
  constructor(private http: HttpClient) { }
  
  getlistCharacter(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
  getCharacterById(id: number): Observable<Person>{
    return this.http.get<Person>(`${this.baseUrl}/${id}`);
  }
}
