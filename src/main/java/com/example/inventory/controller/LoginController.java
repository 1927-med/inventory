package com.example.inventory.controller;

import com.example.inventory.model.LoginRequest;
import com.example.inventory.model.User;
import com.example.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            String token = generateToken(user);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (userService.findByUsername(username) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        User newUser = new User(username, password);
        userService.saveUser(newUser);
        return ResponseEntity.ok("User registered successfully");
    }

    private String generateToken(User user) {
        //TODO I will have to figure out a way how to generate tokens
        return "token";
    }
}
