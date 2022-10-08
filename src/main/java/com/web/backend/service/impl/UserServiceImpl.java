package com.web.backend.service.impl;


import com.web.backend.entity.UserEntity;
import com.web.backend.repository.UserRepository;
import com.web.backend.response.UserDto;
import com.web.backend.security.Encoder;
import com.web.backend.service.UserMapper;
import com.web.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final  Encoder encoder;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, Encoder encoder, UserMapper mapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.mapper = mapper;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public ResponseEntity createUser(UserDto userDto) {

        boolean checkUser = userRepository.findByUsername(userDto.getUsername()).isPresent();
        if(checkUser == false){
           UserEntity userEntity =  mapper.userDtoToUserEntity(userDto);
           userEntity.setPassword(encoder.encrypt(userEntity.getPassword()));
           userRepository.save(userEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity loginUser(UserDto userDto) {
        Optional<UserEntity> user = userRepository.findByUsername(userDto.getUsername());
        if(user.isPresent()
        &&encoder.encrypt(userDto.getPassword()).equals(user.get().getPassword())){
            return new ResponseEntity(mapper.userEntityToUserDto(user.get()),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User updateUser() {
        return null;
    }
}
