import { Component, OnInit } from '@angular/core';
import { Referee } from '../models/referees';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services';
import { first } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'app-referees',
  templateUrl: './referees.component.html',
  styleUrls: ['./referees.component.css']
})
export class RefereesComponent implements OnInit {
  username: 'admin';
  password: 'admin';

    // authorizationData = 'Basic ' + btoa('salesrep:admin');

    httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Basic ${this.authenticationService.userValue.authdata}`,
      }),
    };
  
    referees: Referee[] = [];

  constructor(
    private authenticationService: AuthenticationService,
    private http: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.http
    .get<Referee[]>(`${environment.apiURL}/referees`, this.httpOptions)
    .pipe(first())
    .subscribe((data) => {
      console.log(data);
      this.referees = data;
    });
  }

}
