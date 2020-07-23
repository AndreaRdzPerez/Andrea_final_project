import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './_helpers';
import { AppComponent } from './app.component';
import { MatchesComponent } from './matches/matches.component';
import { RefereesComponent } from './referees/referees.component';
import { LoginComponent } from './login/login.component';
import { TeamsComponent } from './teams/teams.component';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'login',
  },
  { path: 'login', component: LoginComponent },
  {
    path: 'referees',
    component: RefereesComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
  {
    path: 'matches',
    component: MatchesComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
  {
    path: 'teams',
    component: TeamsComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
