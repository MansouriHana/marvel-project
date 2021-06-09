import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Person } from '../model/person';
import { PersonService } from '../services/person.service';

@Component({
  selector: 'app-list-person',
  templateUrl: './list-person.component.html',
  styleUrls: ['./list-person.component.css']
})
export class ListPersonComponent implements OnInit {
  persons!: Observable<Person[]>;
  rows = [];
  personSize: number = -1;
  constructor(private personService: PersonService,private router:Router) { }

  ngOnInit(): void {
    this.personService.getlistCharacter().subscribe((data) => {
      this.personSize = data.length;
     for (var i = 0; i < this.personSize; i += 3) {
        this.rows.push(data.slice(i, i+3));
      }

    }, (error) => {
      console.log("error > ", error);
    });
  }

}
