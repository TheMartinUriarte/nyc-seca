package com.example.nycseca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("/")
    public String findAllUsers() {
        return "It's working!!!";
    }



}