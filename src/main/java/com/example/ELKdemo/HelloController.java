package com.example.ELKdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {


    @RequestMapping("/pulse")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}