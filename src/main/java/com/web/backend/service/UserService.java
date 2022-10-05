package com.web.backend.service;

import com.web.backend.entity.UserEntity;
import com.web.backend.response.UserDto;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

    boolean deleteUser();

    ResponseEntity createUser(UserDto userDto);

    ResponseEntity loginUser(UserDto userDto);

    User updateUser();
}
