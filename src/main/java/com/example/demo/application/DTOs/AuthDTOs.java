package com.example.demo.application.DTOs;

public record AuthDTOs() {
    public record UserCreateDTO(
            String name,
            String email,
            String password,
            String phone,
            String address) {
    }

    public record UserLoginDTO(
            String email,
            String password) {
    }

    public record UserResponseDTO(
            Long id,
            String name,
            String email,
            String phone,
            String address) {
    }
}
