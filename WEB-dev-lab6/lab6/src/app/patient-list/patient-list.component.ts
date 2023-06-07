import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';
import { Patient } from '../class/patient';
import { AppService } from '../app.service';
import { WebsocketService } from '../websocket.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent {
  patients? : Patient[];
  constructor(public app: AppService,private patientServ : PatientService,private router: Router, private webSocketService: WebsocketService){
  }

  ngOnInit() :void {
   this.patientServ.findAll().subscribe(data => {
     this.patients = data;
   });
   this.webSocketService.connectPatient().subscribe((data)=> {
    this.patients = data;
   });
 }
 remove(id : number){
   this.patientServ.deleteBox(id).subscribe(() =>{
     this.router.navigate(['/redirect_patient']);
     this.ngOnInit();
   }
     );

 }
}
