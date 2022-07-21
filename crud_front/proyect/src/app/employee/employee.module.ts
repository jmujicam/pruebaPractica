import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormEmployeeComponent } from './components/form-employee/form-employee.component';
import { FormDetailHoursComponent } from './components/form-detail-hours/form-detail-hours.component';
import { CreateEmployeeComponent } from './pages/create-employee/create-employee.component';
import { CreateDetailHoursComponent } from './pages/create-detail-hours/create-detail-hours.component';
import { SharedModule } from '../shared/shared.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    FormEmployeeComponent,
    FormDetailHoursComponent,
    CreateEmployeeComponent,
    CreateDetailHoursComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports:[
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class EmployeeModule { }
