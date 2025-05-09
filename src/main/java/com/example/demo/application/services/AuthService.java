package com.example.demo.application.services;

import com.example.demo.application.DTOs.AuthDTOs.*;
import com.example.demo.domain.entities.user.User;
import com.example.demo.domain.repositories.UserRepository;
import com.example.demo.domain.valueObjects.Address;

public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserCreateDTO userCreateDTO) {
        Address address = new Address(null, null, null, null);
        User user = User.createUser(userCreateDTO.name(), userCreateDTO.email(), userCreateDTO.password(),
                userCreateDTO.phone(), address);

        userRepository.save(user);

        System.out.println("Registering user: " + userCreateDTO.name());
    }

    public void loginUser(String username, String password) {
        System.out.println("Logging in user: " + username);
    }
}
