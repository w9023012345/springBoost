package com.example.demo;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

//    @RequestMapping("/test")
//    public String test() {
//        return  "Hello world";
//    }

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("hello world");
    }
}