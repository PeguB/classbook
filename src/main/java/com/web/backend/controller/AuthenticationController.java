package com.web.backend.controller;

import com.web.backend.entity.UserEntity;
import com.web.backend.repository.UserRepository;
import com.web.backend.response.UserDto;
import com.web.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin
public class AuthenticationController {

    private final  UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/five")
    public Integer get5(){
        return 6;
    }
    @PostMapping (value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
}
