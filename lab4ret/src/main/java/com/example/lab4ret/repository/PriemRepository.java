package com.example.lab4ret.repository;

import com.example.lab4ret.entity.Priem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriemRepository extends CrudRepository<Priem, Long> {
    List<Priem> findAll();
}
