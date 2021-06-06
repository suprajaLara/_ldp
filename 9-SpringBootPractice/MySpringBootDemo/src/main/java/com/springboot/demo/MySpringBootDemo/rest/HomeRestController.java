package com.springboot.demo.MySpringBootDemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello..! the time on server is: "+ LocalDateTime.now();
    }
}
