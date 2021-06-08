import { Component, Input, OnInit } from '@angular/core';
import { Person } from '../model/person';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {
@Input() person!: Person;
  constructor() { }
  
  ngOnInit(): void {
  }

}
