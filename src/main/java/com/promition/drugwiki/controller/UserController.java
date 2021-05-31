package com.promition.drugwiki.controller;

import com.promition.drugwiki.entity.User;
import com.promition.drugwiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
