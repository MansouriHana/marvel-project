import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CharacterComponent } from './character/character.component';
import { ListPersonComponent } from './list-person/list-person.component';
import { PersonService } from './services/person.service';
import { AppRoutesModule } from './app-routes.module';
import { PersonDetailsComponent } from './person-details/person-details.component';
import { RouterModule } from '@angular/router';

@NgModule({   
  declarations: [
    AppComponent,
    CharacterComponent,
    ListPersonComponent,
    PersonDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutesModule,
    RouterModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
