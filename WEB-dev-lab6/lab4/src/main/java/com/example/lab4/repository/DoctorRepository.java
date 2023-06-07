package com.example.lab4.repository;

import com.example.lab4.Entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
    List<Doctor> findAll();
}
