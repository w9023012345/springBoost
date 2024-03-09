package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @RequestMapping("/product")
    public Prouduct product() {
        Prouduct prouduct = new Prouduct();
        List<String> furite = new ArrayList<String>();
        furite.add("蘋果");
        furite.add("橘子");
        prouduct.setProduct(furite);
        return  prouduct;
    }

    @RequestMapping("/user")
    public Student user() {
        Student student = new Student();
        student.setName("judy");
        return student;
    }

    

}
