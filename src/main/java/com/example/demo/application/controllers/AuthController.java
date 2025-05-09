package com.example.demo.application.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.DTOs.AuthDTOs.*;
import com.example.demo.application.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public void register(@RequestBody UserCreateDTO userCreateDTO) {
        authService.registerUser(userCreateDTO);
    }

    public void login(@RequestBody UserLoginDTO userLoginDTO) {
        authService.loginUser(userLoginDTO.email(), userLoginDTO.password());
    }

}
