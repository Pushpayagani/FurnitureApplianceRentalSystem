package com.rentease.service.impl;

import com.rentease.entity.UserEntity;
import com.rentease.model.UserDTO;
import com.rentease.repository.UserRepository;
import com.rentease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserDTO userDTO){
        UserEntity uEntity=new UserEntity();
        uEntity.setUserId(userDTO.getUserId());
        uEntity.setName(userDTO.getName());
        uEntity.setEmail(userDTO.getEmail());
        uEntity.setPassword(userDTO.getPassword());
        uEntity.setPhone(userDTO.getPhone());

        uEntity=userRepository.save(uEntity);
        return uEntity;
    }

    @Override
    public UserEntity loginUser(String userId, String password) {
        return userRepository.findByUserIdAndPassword(userId, password);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
