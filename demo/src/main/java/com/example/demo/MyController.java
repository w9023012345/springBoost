package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/product")
    public String product() {
        return  "蘋果、橘子";
    }

    @RequestMapping("/user")
    public String user() {
        return "名子";
    }

    

}
