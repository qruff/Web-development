package com.example.lab4.repository;

import com.example.lab4.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
     List<User> findAll();
     User findUserByUsernameAndPassword(String username, String password);
     User findUserByUsername(String username);
     User getUserByUsername(String username);
}
