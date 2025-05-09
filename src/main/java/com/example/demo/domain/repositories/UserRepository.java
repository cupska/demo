package com.example.demo.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.entities.user.User;
import com.example.demo.domain.entities.user.UserId;

public interface UserRepository extends CrudRepository<User, UserId> {

    List<User> findByEmail(String email);

    List<User> findByUsername(String username);

}
