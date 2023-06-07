import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Priem } from './class/priem';

@Injectable({
  providedIn: 'root'
})
export class PriemService {
  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:8082/priems'
  }

  public findAll(): Observable<Priem[]> {
    return this.http.get<Priem[]>(this.URL);

  }
  public deletePriem(id : number) {
    return this.http.delete<Priem>(this.URL+'/'+id);

  }
  public save(wash : Priem) {

    return this.http.post<Priem>(this.URL,wash).subscribe();

  }
  public update(wash : Priem){
    return this.http.put<Priem>(this.URL,wash).subscribe();
  }
  public findById(id : number) : Observable<Priem>{
    return this.http.get<Priem>(this.URL+'/'+id);

  }
}
