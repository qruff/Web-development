import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorsListComponent } from './doctors-list/doctors-list.component';
import { AppComponent } from './app.component';
import { DoctorsAddComponent } from './doctors-add/doctors-add.component';
import { DoctorsUpdComponent } from './doctors-upd/doctors-upd.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientAddComponent } from './patient-add/patient-add.component';
import { PatientUpdComponent } from './patient-upd/patient-upd.component';
import { PriemListComponent } from './priem-list/priem-list.component';
import { PriemDoctorComponent } from './priem-doctor/priem-doctor.component';
import { PriemUpdComponent } from './priem-upd/priem-upd.component';

const routes: Routes = [
  {path: '',  component: DoctorsListComponent},
  {path: 'newdoctor', component: DoctorsAddComponent},
  {path: 'editdoctor/:id', component: DoctorsUpdComponent},
  {path: 'redirect_doctor', redirectTo:''},
  {path: 'patients',  component: PatientListComponent},
  {path: 'newpatient', component: PatientAddComponent},
  {path: 'editpatient/:id', component: PatientUpdComponent},
  {path: 'redirect_patient', redirectTo:'/patients'},
  {path: 'redirect_priem', redirectTo:'/priems'},
  {path: 'priems',  component: PriemListComponent},
  {path: 'newpriem/:id', component: PriemDoctorComponent},
  {path: 'editpriem/:id', component: PriemUpdComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
