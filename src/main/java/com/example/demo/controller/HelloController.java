package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // Declare the Service dependency
    private final GreetingService greetingService;

    // Spring automatically injects the GreetingService instance here
    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // This handles requests to http://localhost:8080/hello
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World") String name) {
//        return "Hello, " + name + "! Your Spring Boot application works.";
        // Delegate the business logic execution to the service tier
        return greetingService.generateGreeting(name);
    }


}