package com.example.lab4.service;

import com.example.lab4.Entity.User;

public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);
}
