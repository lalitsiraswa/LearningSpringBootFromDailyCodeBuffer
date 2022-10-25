package com.dailycodebuffer.Springboot.tutorial.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    This particular value will be fetched from the application.properties
    @Value("${welcome.message}")
    private String welcomeMessage;
//    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    @GetMapping(value = {"/", "/home"})
    public String helloWorld(){
        return welcomeMessage;
    }
}
