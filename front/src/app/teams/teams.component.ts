import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Team } from '../models/teams';
import { AuthenticationService } from '../_services';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {
  teams: Team[] = [];
  username: 'admin';
  password: 'admin';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${this.authenticationService.userValue.authdata}`,
    }),
  };
  constructor(
    private authenticationService: AuthenticationService,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http
    .get<Team[]>(`${environment.apiURL}/teams`, this.httpOptions)
    .subscribe((data) => {
      console.log(data);
      this.teams = data;
    });
  }
}
