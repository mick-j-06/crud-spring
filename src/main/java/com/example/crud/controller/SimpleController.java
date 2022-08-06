package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping(value = "/")
    public String hello(){
        return "✌️✌️✌️ HELLO ✌️✌️✌️";
    }
}
