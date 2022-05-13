package com.car.rental.mycarrental.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/api")
    public String greeting(){

        return "Hello my dear";
    }




}
