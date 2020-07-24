import { Component, OnInit } from '@angular/core';
import { Match } from '../models/matches';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services';
import { first } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-referees',
  templateUrl: './referees.component.html',
  styleUrls: ['./referees.component.css']
})
export class RefereesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
