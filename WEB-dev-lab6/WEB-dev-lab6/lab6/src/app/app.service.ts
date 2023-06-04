import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {
 public authenticated = false;
 public authAdmin = false;
 response : any;
  constructor(private http: HttpClient) {
  }

  authenticate(credentials: { username: string; password: string; }) {
        console.log(credentials);

        this.http.post('http://localhost:8082/vhod',credentials).subscribe(response => {
            this.response = response;

            if (this.response['role']) {
              this.authAdmin = true;
          } else {
              this.authAdmin = false;
          }
            if (this.response['auth']) {
                this.authenticated = true;
            } else {
                this.authenticated = false;
            }
            console.log(this.authenticated + ' '+this.authAdmin);

        });

    }
}
