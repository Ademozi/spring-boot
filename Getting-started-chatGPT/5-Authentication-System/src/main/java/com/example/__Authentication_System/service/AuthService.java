package com.example.__Authentication_System.service;

import com.example.__Authentication_System.dto.*;
import com.example.__Authentication_System.entity.User;
import com.example.__Authentication_System.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;

    public AuthService(UserRepository repository){
        this.repository = repository;
    }

    public AuthResponse register(RegisterRequest request){

        if (repository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = new User(
                request.getEmail(),
                request.getPassword() // Later We Hash It
        );
        repository.save(user);

        return new AuthResponse("User registered successfully");
    }

    public AuthResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return new AuthResponse("Login successful");
    }
}
