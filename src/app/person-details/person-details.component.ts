import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from '../model/person';
import { PersonService } from '../services/person.service';
      
@Component({   
  selector: 'app-person-details',   
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {
  person!: Person;
  constructor(private activateRoute: ActivatedRoute, private router: Router, private personService: PersonService) {
  }

  ngOnInit(): void {
    let id= this.activateRoute.snapshot.params['id'];
    this.getCharacterById(id);
  }

  getCharacterById(id: number) {
    this.personService.getCharacterById(id).subscribe(data => {
      console.log(JSON.stringify(data));
      this.person = data;
    }, error => console.log("Error > " + error));
  }
  BackToCharacterList(){
    this.router.navigate(['characters']);
  }
}
