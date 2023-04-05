package com.example.UserRegistrationapp.Model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "register")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    public String getEmail() {
        return email;
    }
}
