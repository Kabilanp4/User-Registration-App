package com.example.UserRegistrationapp.Controller;


import com.example.UserRegistrationapp.Model.User;
import com.example.UserRegistrationapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/a")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/b")
    @CrossOrigin(origins = "http://localhost:4200")

    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Check if user with given email already exists
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this email already exists");
        }

        // Save user
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

}
