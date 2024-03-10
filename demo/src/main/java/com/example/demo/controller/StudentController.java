package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        studentService.insert(student);
        return "執行insert sql ";
    }

    @PostMapping("/students/batch")
    public String inserList(@RequestBody List<Student> studentList) {
        studentService.insertList(studentList);
        return "執行一批 insert sql ";
    }


    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        studentService.deleteById(studentId);
        return "執行delete sql ";
    }


    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }


}
