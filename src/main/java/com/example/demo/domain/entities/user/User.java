package com.example.demo.domain.entities.user;

import com.example.demo.domain.valueObjects.Address;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import lombok.Data;

@Data
public class User {
    private UserId userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;

    private User(UserId userId, String name, String email, String password, String phoneNumber, Address address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public static User createUser(String name, String email, String password, String phoneNumber,
            Address address) {
        UserId userId = new UserId(); // Assuming UserId has a default constructor
        userId.setId(java.util.UUID.randomUUID().toString()); // Generate a unique ID
        return new User(userId, name, email, "some prefix" + password, phoneNumber, address);
    }
}