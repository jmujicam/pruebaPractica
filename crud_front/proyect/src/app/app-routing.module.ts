import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDetailHoursComponent } from './employee/pages/create-detail-hours/create-detail-hours.component';
import { CreateEmployeeComponent } from './employee/pages/create-employee/create-employee.component';
import { LoginComponent } from './user/login/login.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'registroEmpleados',
    component: CreateEmployeeComponent
  },
  {
    path: 'registroHorasExtras',
    component: CreateDetailHoursComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
