import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ServicesEmployee } from '../../services/servicesEmployee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  //variables
  employeeForm!: FormGroup;
  
  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private employeeServices: ServicesEmployee
  ) { }

  ngOnInit(): void {
    this.employeeForm = this._formBuilder.group({
      name: ['', Validators.required],
      lastname: ['', Validators.required],
      user: ['', Validators.required],
      password: ['', Validators.required],
      salary: ['', Validators.required],
      rol_id: ['', Validators.required],
  });
  }

  newEmployee(){
    const employee = this.employeeForm.value;
    this.employeeServices.postEmployee(employee).subscribe(
        response => {
          if (response.data != null) {
            // Navigate to the redirect url
            this._router.navigateByUrl('/login');
          } else {
            this.employeeForm.enable();
          }
        }, error => {
          console.log(error)
        });
  }

}
