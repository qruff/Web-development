import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Product } from '../model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService  {
  res : any;
  product : Product[] =[
  ];

  constructor(private http: HttpClient) {
  }

  getAdress(page: number) : Observable< Product[]>{

    for(let i = 0; i < 10;i++){
    this.http.get(
      `https://fakerapi.it/api/v1/persons?_locale=en_EN_quantity=1`)
      .subscribe( (response) => {
      this.res = response;
      let prod : Product =
      {
        firstname : this.res.data[0].firstname,
        lastname : this.res.data[0].lastname,
        email : this.res.data[0].email,
        phone : this.res.data[0].phone,
        birthday : this.res.data[0].birthday,
        gender : this.res.data[0].gender,  
      };
      this.product.push(prod);
    });
  }

    return of(this.product);

}

}
