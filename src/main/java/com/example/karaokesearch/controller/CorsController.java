package com.example.karaokesearch.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CorsController {
    @GetMapping("CORS")
    public String cors(){
        System.out.println("cors start");
        return "CORS";
    }
}
