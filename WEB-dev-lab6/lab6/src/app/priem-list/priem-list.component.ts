import { Component, OnInit } from '@angular/core';
import { PriemService } from '../priem.service';
import { Router } from '@angular/router';
import { Priem } from '../class/priem';
import * as moment from 'moment';
import { AppService } from '../app.service';
import {WebsocketService} from '../websocket.service';
@Component({
  selector: 'app-priem-list',
  templateUrl: './priem-list.component.html',
  styleUrls: ['./priem-list.component.css']
})
export class PriemListComponent implements OnInit{
  priems? : Priem[];
  constructor(public app: AppService, private washServ : PriemService,private router: Router, private webSocketService: WebsocketService){
  }

  ngOnInit() :void {
   this.washServ.findAll().subscribe(data => {
     this.priems = data;
   });
   this.webSocketService.connectPriem().subscribe((data) => {
    this.priems = data;
   });
 }
 remove(id : number){
   this.washServ.deletePriem(id).subscribe(() =>{
     this.router.navigate(['/redirect_priem']);
     this.ngOnInit();
   }
);

 }
 retDate(date : Date){
  return moment(date).format('DD MMMM YYYY');;
 }
}
