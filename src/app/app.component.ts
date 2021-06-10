import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonService } from './services/person.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isLoading: boolean = false;
  isInitState: boolean = false;
  isCharacterList: boolean = false;
  constructor(private personeService: PersonService, private router: Router) {

  }
  ngOnInit() {
    this.personeService.getlistCharacter().subscribe((data) => {
      if ((data != undefined) && (data != null)) {
        if (data.length > 0) {
          this.isInitState = false;
          this.isCharacterList = true;
          this.router.navigate(['characters'])
        }else{
          this.isInitState = true;
          this.isCharacterList = false;
        }
      }
    }, error => console.error("error => " + error));
  }
  getDataFromMarvel() {
    console.log("getDataFromMarvel>>>>>>>>>>>>")
    this.isLoading = true;
    this.personeService.getDataFromMarvel().subscribe(data=>{
      this.isLoading = false;
      this.isInitState = false;
      this.isCharacterList = true;
      this.router.navigate(['characters']);
    }, error => console.log("error => "+error));
 
  }


}
