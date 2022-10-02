package com.web.backend.service.impl;


import com.web.backend.entity.UserEntity;
import com.web.backend.repository.UserRepository;
import com.web.backend.response.UserDto;
import com.web.backend.security.Encoder;
import com.web.backend.service.UserMapper;
import com.web.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final  Encoder encoder;
    private final UserMapper mapper;

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {

        boolean checkUser = userRepository.findByUsername(userDto.getUsername()).isPresent();
        if(checkUser == false){
            UserEntity createdUser = UserEntity.builder()
                    .username(userDto.getUsername())
                    .password(encoder.encrypt(userDto.getPassword()))
                    .role(userDto.getRole())
                    .build();
            UserEntity savedEntity = userRepository.save(createdUser);
            UserDto userDto1 = mapper.userEntityToUserDto(savedEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User updateUser() {
        return null;
    }
}
