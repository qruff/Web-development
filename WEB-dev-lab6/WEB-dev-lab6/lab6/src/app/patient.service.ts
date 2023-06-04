import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './class/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:8082/patients'
  }

  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.URL);

  }
  public deleteBox(id : number) {
    return this.http.delete<Patient>(this.URL+'/'+id);

  }
  public save(patient : Patient) {
    console.log(patient);
    return this.http.post<Patient>(this.URL,patient);

  }
  public update(patient : Patient){
    return this.http.put<Patient>(this.URL,patient).subscribe();
  }
  public findById(id : number) : Observable<Patient>{
    return this.http.get<Patient>(this.URL+'/'+id);

  }
}
