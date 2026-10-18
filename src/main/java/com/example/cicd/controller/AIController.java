package com.example.cicd.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai/chat")
    public String generate(@RequestParam(value = "message", defaultValue = "Hello from Spring Boot!") String message) {
        return this.chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}