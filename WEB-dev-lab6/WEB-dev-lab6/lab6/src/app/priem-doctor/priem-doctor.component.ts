import { Component, OnInit } from '@angular/core';
import { PriemService } from '../priem.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../patient.service';
import { Patient } from '../class/patient';
import { Priem } from '../class/priem';
import { DoctorServiceService } from '../doctor-service.service';
import { Doctor } from '../class/doctor';

@Component({
  selector: 'app-priem-doctor',
  templateUrl: './priem-doctor.component.html',
  styleUrls: ['./priem-doctor.component.css']
})
export class PriemDoctorComponent {
  patients! : Patient[];
  priem : Priem = new Priem();
  doctor! : Doctor;
  patient! : Patient;
  id! : number;
  constructor(private washServ : PriemService,private boxServ : PatientService,private carServ : DoctorServiceService,private router: Router,private route :ActivatedRoute){

  }
  ngOnInit() : void{
    this.boxServ.findAll().subscribe((data) => {
      this.patients = data;
   });
   this.carServ.findById(this.route.snapshot.params['id']).subscribe(
    (responce) => {
      this.doctor = responce;
    }
   );
  }
  onSubmit() {

     this.boxServ.findById(this.id).subscribe(
      (responce) => {

        this.patient = responce;
        this.priem.doctor = this.doctor;
         this.priem.patient = this.patient;
         //this.wash.active = true;
        this.washServ.save(this.priem);
      }
     )



    this.gotoUserList();
  }

  gotoUserList() {
    this.router.navigate(['/']);
  }
}
