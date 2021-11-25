package com.curso.monolitica.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class GreetingResource {

    @GetMapping
    public String showGreeting() {
        List<Integer> numbers = new ArrayList<>();
        return "Hello world";
    }
}
