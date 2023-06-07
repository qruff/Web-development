package com.example.lab4;

import com.example.lab4.repository.PatientRepository;
import com.example.lab4.repository.DoctorRepository;
import com.example.lab4.repository.PriemRepository;
import com.example.lab4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab4Application {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PriemRepository priemRepository;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

}
