package com.example.lab4ret.repository;

import com.example.lab4ret.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findAll();
}
