package com.example.lab4.repository;

import com.example.lab4.Entity.Priem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriemRepository extends CrudRepository<Priem,Long> {
    List<Priem> findAll();
}
