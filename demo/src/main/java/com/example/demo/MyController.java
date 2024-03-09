package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MyController {

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                        @RequestParam(defaultValue = "amy", name = "testname") String name) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        return "hello";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        System.out.println("Student:" + student);
        System.out.println("Student id:" + student.getId());
        System.out.println("student name:" + student.getName());
        return "heoolw test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader(defaultValue = "application/json", name = "Content-type") String info) {
        System.out.println("header info:" + info);
        return "hellow test3";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name) {
        System.out.println("path id:" + id);
        System.out.println("path name:" + name);
        return "hello test4";
    }


}
