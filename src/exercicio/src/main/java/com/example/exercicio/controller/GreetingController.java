package com.example.exercicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class GreetingController {

    @GetMapping
    public String sayHello(@RequestParam(defaultValue = "Mundo") String name) {
        return String.format("Olá, %s! Bem-vindo ao projeto Spring Boot de exemplo.", name);
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) {
        return String.format("Recebido ID: %d", id);
    }
}
