package com.example.demo.controller;

import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.response.LoginResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public String anadirUser(@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping(path = "/login")
    public boolean loginEmployee (@RequestBody UserDto userDto){
        return  userService.loginUser(userDto)?true:false;
    }
}
