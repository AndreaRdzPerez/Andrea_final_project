import { Component, OnInit } from '@angular/core';
import { Match } from '../models/matches';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services';
import { first } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  username: 'admin';
  password: 'admin';

    // authorizationData = 'Basic ' + btoa('salesrep:admin');

    httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Basic ${this.authenticationService.userValue.authdata}`,
      }),
    };
  
    matches: Match[] = [];

  constructor(
    private authenticationService: AuthenticationService,
    private http: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.http
    .get<Match[]>(`${environment.apiURL}/matches`, this.httpOptions)
    .pipe(first())
    .subscribe((data) => {
      console.log(data);
      this.matches = data;
    });
  }

}
