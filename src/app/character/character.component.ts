import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from '../model/person';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {
@Input() person!: Person;
  constructor(private router:Router) { }
  
  ngOnInit(): void {
  }
  
  
  goToCharacterDetails(id:number){
    this.router.navigate(['details', id]);
  }

}
