import { Component, OnInit } from '@angular/core';
import { DoctorServiceService } from '../doctor-service.service';
import { Doctor } from '../class/doctor';
import { Router } from '@angular/router';
import { delay } from 'rxjs';
import { AppService } from '../app.service';
import {BsModalRef, BsModalService, ModalOptions} from 'ngx-bootstrap/modal'
import { DoctorsUpdComponent } from '../doctors-upd/doctors-upd.component';
@Component({
  selector: 'app-doctors-list',
  templateUrl: './doctors-list.component.html',
  styleUrls: ['./doctors-list.component.css']
})
export class DoctorsListComponent implements OnInit{
 doctors? : Doctor[];
 bsModalRef?: BsModalRef;
 constructor(public app: AppService,  private doctorService : DoctorServiceService,private router: Router, private modalService: BsModalService){
 }

 ngOnInit() :void {
  this.doctorService.findAll().subscribe(data => {
    this.doctors = data;
  });
}
remove(id : number){
  this.doctorService.deleteDoctor(id).subscribe(() =>{
    this.router.navigate(['/redirect_doctor']);
    this.ngOnInit();
  }
);

}
openModal(){
  const modalOptions: ModalOptions = {
    initialState:{},
    class: 'modal-dialog-centered'
  }
  this.bsModalRef = this.modalService.show(DoctorsUpdComponent);
}
}
