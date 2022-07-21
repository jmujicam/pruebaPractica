import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //variables
  signInForm!: FormGroup;
  
  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _authService: ServicesService,
  ) { }

  ngOnInit(): void {
    this.signInForm = this._formBuilder.group({
      user: ['', Validators.required],
      password: ['', Validators.required]
  });
  }

  singIn(){
    if (this.signInForm.invalid) {
      return;
    }

    const usuario = this.signInForm.value;

    this._authService.signIn(usuario).subscribe(
      response =>{
        if (response.data != null) {
          // Navigate to the redirect url
          this._router.navigateByUrl('/registroHorasExtras');
        } else {
          this.signInForm.enable();
        }
      },error => {
        console.log(error)
        
      });
    
  }

}
