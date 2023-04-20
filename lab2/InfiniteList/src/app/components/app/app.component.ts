import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/person.service";
import {Product} from "../../model/Product";
import { delay } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'InfiniteList';
  gridColumns = 3;
  page = 1;
  products: Product[] =[ ];
  constructor(private productService: ProductService) {}
  ngOnInit(): void {

    this.productService.
    getAdress(this.page).
    subscribe((prod : Product[] ) => {
     this.products = prod
    });

  }

    onScroll(): void {

    this.productService.
    getAdress(this.page++).
    subscribe((prod : Product[]) => {
      this.products = prod
    });
  }

}
