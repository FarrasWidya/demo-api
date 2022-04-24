package com.domain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class welcomeController {

    @GetMapping
    public String welcome(String name){
        return String.format("welcome, %s", name);
    } 
}
