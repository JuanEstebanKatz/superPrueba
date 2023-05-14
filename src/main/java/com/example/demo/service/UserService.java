package com.example.demo.service;

import com.example.demo.dto.UserDto;


public interface UserService {
    String addUser(UserDto userDto);

    boolean loginUser(UserDto loginUserDto);
}
