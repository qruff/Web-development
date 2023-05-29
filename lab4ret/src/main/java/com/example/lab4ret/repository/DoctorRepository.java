package com.example.lab4ret.repository;

import com.example.lab4ret.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findAll();
}
