import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListPersonComponent } from './list-person/list-person.component';
import { PersonDetailsComponent } from './person-details/person-details.component';
import { CharacterComponent } from './character/character.component';

const appRoutes: Routes = [
  { path: "", redirectTo:"/characters", pathMatch: "full" },
  { path: "characters", component: ListPersonComponent },
  { path: "details/:id", component: PersonDetailsComponent },
  { path: "character", component: CharacterComponent }
]
 

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ]
})
export class AppRoutesModule { }
