package com.example.demo.service.impl;

import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.response.LoginResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDto userDto) {

        User user = new User( userDto.getUserId(),
                userDto.getUserName(),
               this.passwordEncoder.encode(userDto.getPassword()));

        userRepo.save(user);

        return user.getUserName();
    }

    @Override
    public boolean loginUser(UserDto loginUserDto) {
        return userRepo.findById(loginUserDto.getUserId()) != null;
    }


}
