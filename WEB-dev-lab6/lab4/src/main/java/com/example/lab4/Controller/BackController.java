package com.example.lab4.Controller;

import com.example.lab4.Entity.Doctor;
import com.example.lab4.Entity.Patient;
import com.example.lab4.Entity.Priem;
import com.example.lab4.service.PatientService;
import com.example.lab4.service.DoctorService;
import com.example.lab4.service.PriemService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BackController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PriemService priemService;
    private final SimpMessagingTemplate messagingTemplate;
    public BackController(DoctorService doctorService, PatientService patientService, PriemService priemService, SimpMessagingTemplate messagingTemplate) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.priemService = priemService;
        this.messagingTemplate = messagingTemplate;
    }
    //CARS
    @GetMapping(value = "/doctors")
    public List getDoctors(){

        System.out.println("ALL");
        return doctorService.getAllDoctors();
    }
    @DeleteMapping(value = "/doctors/{id}")
    public void delDoctor(@PathVariable Long id){
        System.out.println(id +" DELETE");
        doctorService.deleteDoctorById(id);
        updateDoctor();
    }
    @PostMapping(value="/doctors")
    public void saveDoctor(@RequestBody Doctor doctor){
        System.out.println(doctor.getLastname() + " SAVED ");
        doctorService.saveDoctor(doctor);
        updateDoctor();
    }
    @GetMapping(value = "/doctors/{id}")
    public Doctor doctorById(@PathVariable Long id){

        System.out.println(id + " I did it");
        return doctorService.getDoctorById(id);
    }
    @PutMapping(value = "/doctors")
    public void editDoctor(@RequestBody Doctor doctor){
        System.out.println(doctor.getLastname() + " EDITING");
        doctorService.editDoctor(doctor);
        updateDoctor();
    }
    @MessageMapping("/doctor")
    public void updateDoctor(){
        messagingTemplate.convertAndSend("/topic/doctors", doctorService.getAllDoctors());
    }
//    ********************
    //BOXES
//    ***********************
    @GetMapping(value = "/patients")
    public List getPatients(){
        System.out.println("ALL PATIENTS");
        return patientService.getAllPatient();
    }
    @DeleteMapping(value = "/patients/{id}")
    public void delPatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        updateData();
    }
    @PostMapping(value="/patients")
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
        updateData();
    }
    @GetMapping(value = "/patients/{id}")
    public Patient patientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }
    @PutMapping(value = "/patients")
    public void editPatient(@RequestBody Patient patient){
        patientService.editPatient(patient);
        updateData();
    }

    @MessageMapping("/patient")
    public void updateData(){
        messagingTemplate.convertAndSend("/topic/patients", patientService.getAllPatient());
    }
    //    ********************
    //WASHES
//    ***********************
    @GetMapping(value = "/priems")
    public List getPriems(){
        return priemService.getAllPriem();
    }
    @DeleteMapping(value = "/priems/{id}")
    public void delPriem(@PathVariable Long id){
        priemService.deletePriemById(id);
        updatePriem();
    }
    @PostMapping(value="/priems")
    public void savePriem(@RequestBody Priem priem){
        Doctor doctor = doctorService.getDoctorById(priem.getDoctor().getId());
        doctorService.editDoctor(doctor);
        priemService.savePriem(priem);
        updateDoctor();
        updatePriem();
    }
    @GetMapping(value = "/priems/{id}")
    public Priem priemById(@PathVariable Long id){
        return priemService.getPriemById(id);
    }
    @PutMapping(value = "/priems")
    public void editPriem(@RequestBody Priem priem){
        priemService.editPriem(priem);
        updatePriem();
    }
    @MessageMapping("/priem")
    public void updatePriem(){
        messagingTemplate.convertAndSend("/topic/priems", priemService.getAllPriem());
    }
}
