package com.udemy.compras.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloHorld {
    @GetMapping
    public String hello(){
        return "Ola Azor Carlos.<br> Deus é contigo";
    }
}
