package com.example.demo; // Change this based on your package structure

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This makes it a REST API Controller
@RequestMapping("/") // Maps root URL "/"
public class HomeController {
    @GetMapping // Handles GET requests
    public String home() {
        return "Welcome to my Spring Boot Application!";
    }
}

