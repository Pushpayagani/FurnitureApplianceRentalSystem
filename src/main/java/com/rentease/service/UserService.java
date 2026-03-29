package com.rentease.service;

import com.rentease.entity.UserEntity;
import com.rentease.model.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserEntity saveUser(UserDTO userDTO);


    UserEntity loginUser(String userId, String password);

    UserEntity getUserById(Long id);
}
