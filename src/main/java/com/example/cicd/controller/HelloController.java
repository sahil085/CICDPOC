package com.example.cicd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${test-secret-key:Default Message}")
    private String awsMessage;

    @GetMapping("/aws-message")
    public String getMessage() {
        return awsMessage;
    }
}