import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResponseApiUserI, UserI } from '../interfaces/user.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  baseURL= 'http://localhost:8080/api/login';

  constructor(private http: HttpClient) { }

  signIn(user: UserI): Observable<ResponseApiUserI>{    
     return this.http.post<ResponseApiUserI>(this.baseURL, user);
  }
}
