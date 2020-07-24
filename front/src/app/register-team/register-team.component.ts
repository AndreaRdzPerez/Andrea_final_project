import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { first } from 'rxjs/operators';
import { Team } from '../models/teams';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register-team',
  templateUrl: './register-team.component.html',
  styleUrls: ['./register-team.component.css']
})
export class RegisterTeamComponent implements OnInit {
  isValid = false;
  teamForm: FormGroup = new FormGroup({
    name: new FormControl(),
    captainId: new FormControl(),
    teamMembersNum: new FormControl(),
  });
  loading = false;
  returnUrl = '/teams';
  error = '';
  constructor(
    private toastr: ToastrService,
    private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService,
    private http: HttpClient
  ) {}

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${this.authenticationService.userValue.authdata}`,
    }),
  };

  ngOnInit(): void {
    this.teamForm = this.formBuilder.group({
      name: ['', Validators.required],
      captainId: [
        '',Validators.required
      ],
      teamMembersNum: [
        '',
          Validators.required      ],

    });

    this.teamForm.valueChanges.subscribe((input) => {
      this.isValid = !this.teamForm.invalid;
    });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.teamForm.controls;
  }

  onSubmit() {
    const newTeam = {
        name: this.f.name.value,
        captainId: this.f.phone.value,
        teamMembersNum: this.f.email.value,
    };
    this.http
      .post<Team>(`${environment.apiURL}/lead`, newTeam, this.httpOptions)
      .subscribe(
        (data) => {
          this.toastr.success(
            '<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Lead created!',
            '',
            {
              timeOut: 2000,
              enableHtml: true,
              toastClass: 'alert alert-success alert-with-icon',
              positionClass: 'toast-top-center',
            }
          );
          console.log(data), this.router.navigate([this.returnUrl]);
        },
        (error) => {
          this.toastr.error(
            `<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> ${error}`,
            '',
            {
              timeOut: 2000,
              enableHtml: true,
              toastClass: 'alert alert-danger alert-with-icon',
              positionClass: 'toast-top-center',
            }
          );
        }
      );
  }
}

