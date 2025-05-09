package com.example.demo.domain.entities.user;

import java.util.UUID;

import lombok.Data;

@Data
public class UserId {
    UUID id;

    public void setId(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}