package com.web.backend.controller;

import com.web.backend.response.UserDto;
import com.web.backend.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity signUp(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserDto userDto) {
        return userService.loginUser(userDto);
    }
}
