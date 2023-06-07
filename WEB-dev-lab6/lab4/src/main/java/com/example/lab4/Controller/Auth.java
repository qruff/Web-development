package com.example.lab4.Controller;

import com.example.lab4.Entity.User;
import com.example.lab4.repository.UserRepository;
import com.example.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Auth {
    private final UserService userService;
    public Auth(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/vhod")
    public Map<String,Object> getAuth(@RequestBody User user){
        Map<String,Object> map=new HashMap<>();
        User us = userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(us != null){
            map.put("auth",true);
            if(Objects.equals(us.getRol(), "ADMIN"))
            map.put("role",true);
            else
                map.put("role",false);
            return map;

        }
        else {
            map.put("auth",false);
            return map;
        }
    }
}
