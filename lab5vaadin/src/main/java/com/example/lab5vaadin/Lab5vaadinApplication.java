package com.example.lab5vaadin;

import com.example.lab5vaadin.data.repository.DoctorRepository;
import com.example.lab5vaadin.data.repository.PatientRepository;
import com.example.lab5vaadin.data.repository.PriemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab5vaadinApplication {

    @Autowired
    public Lab5vaadinApplication(PatientRepository patientRepository, DoctorRepository doctorRepository, PriemRepository priemRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.priemRepository = priemRepository;
    }
    public PatientRepository patientRepository;
    public DoctorRepository doctorRepository;
    public PriemRepository priemRepository;
    public static void main(String[] args) {
        SpringApplication.run(Lab5vaadinApplication.class, args);
    }

}
