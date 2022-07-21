import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeI, ResponseApiEmployeeI } from '../interfaces/employee.interface';

@Injectable({
  providedIn: 'root'
})
export class ServicesEmployee {

  baseURL= 'http://localhost:8080/api/employee';

  constructor(private http: HttpClient) { }

  postEmployee(employee: EmployeeI): Observable<ResponseApiEmployeeI>{    
    return this.http.post<ResponseApiEmployeeI>(this.baseURL, employee);
 }

}
