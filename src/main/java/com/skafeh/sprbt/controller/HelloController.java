package com.skafeh.sprbt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//components higher abstraction is controller
//rest controller has a request body attached to it by default
@RestController
public class HelloController {

    // TO change this verbose --> @RequestMapping(value = "/", method = RequestMethod.GET)

    @Value("${welcome.message}")
    private String welcomeMessage;
    @GetMapping(value = "/")
    public String helloWorld(){
        return welcomeMessage;
    }
}



