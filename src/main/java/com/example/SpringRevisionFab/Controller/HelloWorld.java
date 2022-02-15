package com.example.SpringRevisionFab.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String HelloWorld(){
        String s1=  "Hi This is First Page of Spring boot application";
        return s1;
    }
}
