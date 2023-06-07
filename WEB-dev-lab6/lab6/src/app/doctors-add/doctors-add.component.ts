import { Component } from '@angular/core';
import { Doctor } from '../class/doctor';
import { DoctorServiceService } from '../doctor-service.service';
import { Router } from '@angular/router';
import { DoctorsListComponent } from '../doctors-list/doctors-list.component';
import {BsModalRef, ModalOptions, BsModalService} from 'ngx-bootstrap/modal';
@Component({
  selector: 'app-doctors-add',
  templateUrl: './doctors-add.component.html',
  styleUrls: ['./doctors-add.component.css']
})
export class DoctorsAddComponent {
  doctor : Doctor = new Doctor();
  constructor(private carServ : DoctorServiceService,private router: Router, public bsModalRef:BsModalRef, private modalService: BsModalService){

  }
  
  onSubmit() {
    this.carServ.save(this.doctor).subscribe(
      () =>{
        this.gotoUserList();
      }
    );

  }

  openModal(){
    const modalOptions: ModalOptions = {
      initialState:{},
      class: 'modal-dialog-centered'
    }
    this.bsModalRef = this.modalService.show(DoctorsAddComponent);
  }
  gotoUserList() {
    this.router.navigate(['/']);
  }
}
