package com.example.lab4ret;

import com.example.lab4ret.repository.DoctorRepository;
import com.example.lab4ret.repository.PatientRepository;
import com.example.lab4ret.repository.PriemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Access;

@SpringBootApplication
public class Lab4retApplication {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PriemRepository priemRepository;
    public static void main(String[] args) {
        SpringApplication.run(Lab4retApplication.class, args);
    }

}
