package com.web.backend.controller;

import com.web.backend.entity.UserEntity;
import com.web.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/hello")
    public ResponseEntity<?> hello(){
        UserEntity userEntity = UserEntity.builder().username("fsfsdsd").password("1").build();
        return new ResponseEntity<>(userRepository.save(userEntity), HttpStatus.OK);
    }
}
