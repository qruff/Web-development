import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Doctor } from './class/doctor';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DoctorServiceService {
private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:8082/doctors'
  }

  public findAll(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(this.URL);

  }
  public deleteDoctor(id : number) {
    return this.http.delete<Doctor>(this.URL+'/'+id);

  }
  public save(car : Doctor) {
    return this.http.post<Doctor>(this.URL,car);

  }
  public update(car : Doctor){
    return this.http.put<Doctor>(this.URL,car).subscribe();
  }
  public findById(id : number) : Observable<Doctor>{
    return this.http.get<Doctor>(this.URL+'/'+id);

  }
}
