package com.example.lab4ret.controller;

import com.example.lab4ret.entity.*;
import com.example.lab4ret.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    private final PriemService priemService;
    private final PatientService patientService;
    @Autowired
    public DoctorController(DoctorService doctorService, PriemService priemService, PatientService patientService) {
        this.doctorService = doctorService;
        this.priemService = priemService;
        this.patientService = patientService;
    }

    @PostMapping
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
    @GetMapping
    public String listDoctors(Model model){
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }
    @GetMapping("/newdoctor")
    public String newDoctor(Model model){
        Doctor doctor = new Doctor();
        Priem priem = new Priem();
        model.addAttribute("priem", priem);
        model.addAttribute("doctor", doctor);
        model.addAttribute("patients",patientService.getAllPatients());
        return "newdoctor";
    }
    @GetMapping("/newpatient")
    public String newPatient(Model model){
        Patient patient = new Patient();
        model.addAttribute("patient",patient);
        return "newpatient";
    }
    @PostMapping("/newpatient")
    public String newPatient(@ModelAttribute("patient") Patient patient){
        patientService.savePatient(patient);
        return "redirect:/doctors";
    }
    @GetMapping("/patient")
    public String listPatient(Model model){
        List<Patient> listpatient = patientService.getAllPatients();
        model.addAttribute("patients",listpatient);
        return "patients";
    }
    @GetMapping ("/del/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }
    @GetMapping("/edit/{id}")
    public String editDoctor(@PathVariable Long id,Model model){
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "editdoctor";
    }
    @PostMapping("/edit/{id}")
    public  String editDoctor(@PathVariable Long id,@ModelAttribute("doctor") Doctor doctor){
        Doctor upmovie = doctorService.getDoctorById(id);
        upmovie.setId(id);
        upmovie.setFirstname(doctor.getFirstname());
        upmovie.setLastname(doctor.getLastname());
        upmovie.setMiddlename(doctor.getMiddlename());
        upmovie.setPriems(doctor.getPriems());
        upmovie.setType(doctor.getType());
        doctorService.editDoctor(upmovie);
        return "redirect:/doctors";
    }
    @GetMapping("/priem/{id}")
    public String priem(@PathVariable Long id, Model model){
        model.addAttribute("doctor",id);
        Priem priem = new Priem();
        model.addAttribute("priem", priem);
        model.addAttribute("patients",patientService.getAllPatients());
        return "priem";
    }
    @PostMapping("/priem/{id}")
    public String savePriem(@PathVariable Long id, @ModelAttribute("priem") Priem priem){
        Doctor svmovie = doctorService.getDoctorById(id);

        svmovie.setId(id);
        priem.setDoctor(svmovie);
        doctorService.editDoctor(svmovie);
        priemService.savePriem(priem);
        return "redirect:/doctors";
    }
    @GetMapping("/priems")
    public String allPriems(Model model){
        model.addAttribute("priems",priemService.getAllPriems());
        return "priems";
    }
    @GetMapping("/patient/del/{id}")
    public String delPatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return "redirect:/doctors/patient";
    }
    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable Long id,Model model){
        model.addAttribute("patient",patientService.getPatientById(id));
        return "editpatient";
    }
    @PostMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable Long id,@ModelAttribute("patient") Patient patient){
        Patient editviewer = patientService.getPatientById(id);
        editviewer.setId(id);
        editviewer.setFirstname(patient.getFirstname());
        editviewer.setLastname(patient.getLastname());
        editviewer.setMiddlename(patient.getMiddlename());
        editviewer.setPriems(patient.getPriems());
        patientService.editPatient(editviewer);
        return "redirect:/doctors/patient";
    }
    @GetMapping("/priems/del/{id}")
    public String delPriem(@PathVariable Long id){
        priemService.deletePriemById(id);
        return "redirect:/doctors/priems";
    }
    /*@GetMapping("/edit/{id}")
    public String editPriem(@PathVariable Long id,Model model){
        model.addAttribute("priem", priemService.getPriemById(id));
        return "editpriem";
    }
    @PostMapping("/edit/{id}")
    public  String editPriem(@PathVariable Long id,@ModelAttribute("doctor") Doctor doctor){
        Priem upmovie = priemService.getPriemById(id);
        List<Patient> patient = patientService.getAllPatients();
        upmovie.setId(id);
        upmovie.setDoctor(doctor);
        upmovie.setPatient(patient);
        upmovie.setMiddlename(doctor.getMiddlename());
        upmovie.setPriems(doctor.getPriems());
        upmovie.setType(doctor.getType());
        doctorService.editDoctor(upmovie);
        return "redirect:/doctors";
    }*/
}
